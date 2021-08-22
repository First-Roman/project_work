package com.firstroman.botconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorMessageDTO {
    public ErrorMessageDTO(String message) {
        this.message = message;
        this.type = "error";
    }

    private String message;
    private String type;
}
