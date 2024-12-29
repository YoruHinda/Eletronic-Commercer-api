package com.github.yoruhinda.eletronicCommercer.controller;

import com.github.yoruhinda.eletronicCommercer.domain.dto.user.LoginResponseDTO;
import com.github.yoruhinda.eletronicCommercer.domain.dto.user.authenticationDTO;
import com.github.yoruhinda.eletronicCommercer.domain.dto.user.registerDTO;
import com.github.yoruhinda.eletronicCommercer.domain.entity.enumerated.UserRoleEnumerated;
import com.github.yoruhinda.eletronicCommercer.domain.entity.user.User;
import com.github.yoruhinda.eletronicCommercer.repository.UserRepository;
import com.github.yoruhinda.eletronicCommercer.services.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid authenticationDTO auth){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(auth.username(), auth.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        User authenticateUser = (User) authenticate.getPrincipal();
        String token = tokenService.generateToken(authenticateUser);
        return ResponseEntity.ok(new LoginResponseDTO(token, authenticateUser.getUsername(), authenticateUser.getUserRole()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid registerDTO register){
        if(userRepository.findByUsername(register.username()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(register.password());
        User user = new User(register.username(), encryptedPassword);
        user.setUserRole(UserRoleEnumerated.USER);
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
