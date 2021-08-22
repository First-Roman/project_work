package com.firstroman.botconstructor.service.preference;

import com.firstroman.botconstructor.dto.UserPreferenceDTO;
import com.firstroman.botconstructor.exception.UserPreferenceException;

public interface UserPreferenceService {

    void saveUserPreference(UserPreferenceDTO userPreference);

    UserPreferenceDTO getUserPreference() throws UserPreferenceException;
}
