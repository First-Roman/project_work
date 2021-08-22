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
@Document(value = "customers")
public class Customer {
    @Id
    private String id;

    private Long telegramId;

    private String telegramUsername;

    private String insertDate;

    private String affiliationId;

}
