package com.firstroman.botconstructor.service.security;

import com.firstroman.botconstructor.dto.LoginDTO;

public interface AuthenticationUser {

    void login(LoginDTO loginDTO);
}
