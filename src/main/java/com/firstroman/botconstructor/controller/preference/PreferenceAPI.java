package com.firstroman.botconstructor.controller.preference;

import com.firstroman.botconstructor.dto.UserPreferenceDTO;
import com.firstroman.botconstructor.exception.UserPreferenceException;
import com.firstroman.botconstructor.service.preference.UserPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PreferenceAPI {
    private final UserPreferenceService userPreferenceService;

    @GetMapping(value = "/preference")
    public ResponseEntity getUserPreference() throws UserPreferenceException {
        return ResponseEntity.ok().body(userPreferenceService.getUserPreference());
    }

    @PostMapping(value = "bot-token", consumes = {"multipart/form-data"})
    public ResponseEntity setToken(UserPreferenceDTO userPreferenceDTO) {
        userPreferenceService.saveUserPreference(userPreferenceDTO);
        return ResponseEntity.ok().build();
    }
}
