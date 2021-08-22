package com.firstroman.botconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserPreferenceDTO {

    private String telegramUsername;

    private Long telegramId;

    private String login;

    private String userToken;

    private String botToken;

    private String insertDate;
}
