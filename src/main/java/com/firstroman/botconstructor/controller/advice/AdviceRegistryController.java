package com.firstroman.botconstructor.controller.advice;

import com.firstroman.botconstructor.dto.ErrorMessageDTO;
import com.firstroman.botconstructor.exception.UserRegistryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AdviceRegistryController {

    @ExceptionHandler(UserRegistryException.class)
    public ResponseEntity exceptionHandler(UserRegistryException e) {
        log.error("Ошибка в модуле Registry ", e);
        return ResponseEntity.badRequest().body(new ErrorMessageDTO(e.getMessage()));
    }
}
