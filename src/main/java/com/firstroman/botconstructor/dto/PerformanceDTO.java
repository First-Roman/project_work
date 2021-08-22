package com.firstroman.botconstructor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PerformanceDTO {

    private String id;

    private MultipartFile file;

    private String command;

    private String message;

}
