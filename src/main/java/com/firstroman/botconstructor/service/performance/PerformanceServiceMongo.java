package com.firstroman.botconstructor.service.performance;

import com.firstroman.botconstructor.convertor.perfomance.ConverterPerformanceDTOToPerformance;
import com.firstroman.botconstructor.convertor.perfomance.ConverterPerformanceToPerformanceDTO;
import com.firstroman.botconstructor.dto.PerformanceDTO;
import com.firstroman.botconstructor.model.Performance;
import com.firstroman.botconstructor.model.UserPreference;
import com.firstroman.botconstructor.repository.performance.PerformanceRepository;
import com.firstroman.botconstructor.repository.preference.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@RequiredArgsConstructor
@Service
@SessionScope
public class PerformanceServiceMongo implements PerformanceService {

    private final ConverterPerformanceDTOToPerformance converterPerformanceDTOToPerformance;

    private final ConverterPerformanceToPerformanceDTO converterPerformanceToPerformanceDTO;

    private final PerformanceRepository performanceRepository;

    private final UserPreferenceRepository userPreferenceRepository;

    private String userToken;

    @Override
    public void savePerformance(PerformanceDTO performanceDTO) {
        if (userToken == null) {
            String login = SecurityContextHolder.getContext().getAuthentication().getName();
            UserPreference userPreference = userPreferenceRepository.findByLogin(login);
            userToken = userPreference.getUserToken();
        }
        Performance performance = converterPerformanceDTOToPerformance.convert(performanceDTO);
        performance.setUserToken(userToken);
        performanceRepository.save(performance);
    }

    @Override
    public PerformanceDTO getPerformanceByCommand(String command) {
        Performance performance = performanceRepository.findByCommand(command);
        if (performance == null) {
            return new PerformanceDTO();
        }
        return converterPerformanceToPerformanceDTO.convert(performance);
    }
}
