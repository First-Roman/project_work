package com.firstroman.botconstructor.service.preference;

import com.firstroman.botconstructor.convertor.preference.ConvertUserPreferenceToUserPreferenceDTO;
import com.firstroman.botconstructor.dto.UserPreferenceDTO;
import com.firstroman.botconstructor.exception.UserPreferenceException;
import com.firstroman.botconstructor.model.UserPreference;
import com.firstroman.botconstructor.repository.preference.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPreferenceServiceMongo implements UserPreferenceService {

    private final ConvertUserPreferenceToUserPreferenceDTO converter;
    private final UserPreferenceRepository userPreferenceRepository;


    @Override
    public void saveUserPreference(UserPreferenceDTO userPreferenceDTO) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        UserPreference userPreference = userPreferenceRepository.findByLogin(login);
        userPreference.setBotToken(userPreferenceDTO.getBotToken());
        userPreferenceRepository.save(userPreference);
    }

    @Override
    public UserPreferenceDTO getUserPreference() throws UserPreferenceException {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        UserPreference userPreference = userPreferenceRepository.findByLogin(login);
        if (userPreference == null) {
            throw new UserPreferenceException("Ошибка, не найден объект с пользовательскими настройками!");
        }
        return converter.convert(userPreference);
    }
}
