package com.firstroman.botconstructor.controller.security.simpleresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SimpleResponse {
    SUCCESS_REGISTRATION("{\"message\":\"success\",\"type\":\"registration\"}"),
    SUCCESS_LOGIN("{\"message\":\"success\",\"type\":\"login\"}");
    private String response;
}
