package com.firstroman.botconstructor.service.performance;

import com.firstroman.botconstructor.dto.PerformanceDTO;

public interface PerformanceService {
    void savePerformance(PerformanceDTO performanceDTO);

    PerformanceDTO getPerformanceByCommand(String command);
}
