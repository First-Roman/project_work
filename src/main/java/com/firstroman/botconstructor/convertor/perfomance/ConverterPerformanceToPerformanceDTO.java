package com.firstroman.botconstructor.convertor.perfomance;

import com.firstroman.botconstructor.dto.PerformanceDTO;
import com.firstroman.botconstructor.model.Performance;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterPerformanceToPerformanceDTO implements Converter<Performance, PerformanceDTO> {
    @Override
    public PerformanceDTO convert(Performance performance) {
        PerformanceDTO performanceDTO = new PerformanceDTO();
        performanceDTO.setCommand(performance.getCommand());
        performanceDTO.setId(performance.getId());
        performanceDTO.setMessage(performance.getMessage());
        return performanceDTO;
    }
}
