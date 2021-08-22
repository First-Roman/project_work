package com.firstroman.botconstructor.convertor.preference;

import com.firstroman.botconstructor.dto.UserPreferenceDTO;
import com.firstroman.botconstructor.model.UserPreference;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertUserPreferenceToUserPreferenceDTO implements Converter<UserPreference, UserPreferenceDTO> {
    @Override
    public UserPreferenceDTO convert(UserPreference userPreference) {
        UserPreferenceDTO userPreferenceDTO = new UserPreferenceDTO();
        userPreferenceDTO.setLogin(userPreference.getLogin());
        userPreferenceDTO.setInsertDate(userPreference.getInsertDate());
        userPreferenceDTO.setBotToken(userPreference.getBotToken());
        userPreferenceDTO.setTelegramUsername(userPreference.getTelegramUsername());
        userPreferenceDTO.setUserToken(userPreference.getUserToken());
        userPreferenceDTO.setTelegramId(userPreference.getTelegramId());
        return userPreferenceDTO;
    }
}
