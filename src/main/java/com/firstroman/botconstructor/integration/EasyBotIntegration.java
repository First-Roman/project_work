package com.firstroman.botconstructor.integration;

import com.firstroman.botconstructor.dto.EasyBotDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class EasyBotIntegration {

    @Value("${bot.constructor.url}")
    private String uri;

    private final RestTemplate restTemplate;

    public void addBot(EasyBotDTO easyBotDTO) {
        String url = uri + "/bot";
        restTemplate.postForLocation(url, easyBotDTO);
    }

}
