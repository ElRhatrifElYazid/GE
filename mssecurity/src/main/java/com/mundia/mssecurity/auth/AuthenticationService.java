package com.mundia.mssecurity.auth;

import com.mundia.mssecurity.config.JwtService;
import com.mundia.mssecurity.user.Role;
import com.mundia.mssecurity.user.User;
import com.mundia.mssecurity.userRepo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
private final UserRepo userRepo;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;
private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .email(registerRequest.getEmail())
                .role(Role.USER)
                .motDePasse(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userRepo.save(user);
        var jwt = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwt).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword())
        );

        var user = userRepo.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        System.out.println(user);
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwt).build();

    }
}
