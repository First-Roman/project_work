package com.firstroman.botconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String id;

    private String telegramUsername;

    private Long telegramId;

    private String insertDate;
}
