package com.firstroman.botconstructor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "preference")
public class UserPreference {
    @Id
    private String id;

    private String login;

    private String telegramUsername;

    private Long telegramId;

    private String userToken;

    private String botToken;

    private String insertDate;
}
