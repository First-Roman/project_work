package com.firstroman.botconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistryDTO {

    private String username;

    private String password;

    private String password2;

    private String userToken;

}
