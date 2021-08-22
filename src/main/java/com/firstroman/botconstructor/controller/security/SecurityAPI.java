package com.firstroman.botconstructor.controller.security;

import com.firstroman.botconstructor.controller.security.simpleresponse.SimpleResponse;
import com.firstroman.botconstructor.dto.LoginDTO;
import com.firstroman.botconstructor.dto.RegistryDTO;
import com.firstroman.botconstructor.exception.UserRegistryException;
import com.firstroman.botconstructor.service.security.AuthenticationUser;
import com.firstroman.botconstructor.service.security.UserRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class SecurityAPI {

    private final UserRegistry userRegistry;

    private final AuthenticationUser authenticationUser;

    @PostMapping(value = "/registry", consumes = {"multipart/form-data"})
    public ResponseEntity registry(RegistryDTO registryDTO) throws UserRegistryException {
        userRegistry.registry(registryDTO);
        return ResponseEntity.ok().body(SimpleResponse.SUCCESS_REGISTRATION.getResponse());
    }

    @PostMapping(value = "/login", consumes = {"multipart/form-data"})
    public ResponseEntity login(LoginDTO loginDTO) {
        authenticationUser.login(loginDTO);
        return ResponseEntity.ok().body(SimpleResponse.SUCCESS_LOGIN.getResponse());
    }

    @GetMapping(value = "/user")
    public ResponseEntity registry() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        return ResponseEntity.ok().body("Good" + username);
    }
}
