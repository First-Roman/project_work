package com.firstroman.botconstructor.service.bot;

import com.firstroman.botconstructor.convertor.bot.ConverterUserPreferenceToEasyBotDTO;
import com.firstroman.botconstructor.integration.EasyBotIntegration;
import com.firstroman.botconstructor.model.UserPreference;
import com.firstroman.botconstructor.repository.preference.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BotServiceImpl implements BotService {

    private final EasyBotIntegration easyBotIntegration;
    private final UserPreferenceRepository userPreferenceRepository;
    private final ConverterUserPreferenceToEasyBotDTO converter;

    @Override
    public void start() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        UserPreference userPreference = userPreferenceRepository.findByLogin(login);
        easyBotIntegration.addBot(converter.convert(userPreference));
    }
}
