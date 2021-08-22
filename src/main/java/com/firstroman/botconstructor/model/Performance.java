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
@Document(value = "performance")
public class Performance {

    @Id
    private String id;

    private String userToken;

    private String command;

    private String message;

    private byte[] file;

    private String filename;
}
