package com.firstroman.botconstructor.convertor.bot;

import com.firstroman.botconstructor.dto.EasyBotDTO;
import com.firstroman.botconstructor.model.UserPreference;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterUserPreferenceToEasyBotDTO implements Converter<UserPreference, EasyBotDTO> {
    @Override
    public EasyBotDTO convert(UserPreference userPreference) {
        return new EasyBotDTO(userPreference.getUserToken(), userPreference.getBotToken());
    }
}
