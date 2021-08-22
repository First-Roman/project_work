package com.firstroman.botconstructor.controller.bot;

import com.firstroman.botconstructor.service.bot.BotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class BotAPI {

    private final BotService botService;

    @PostMapping(value = "/start")
    public ResponseEntity startBot() {
        botService.start();
        return ResponseEntity.ok().build();
    }
}
