package com.firstroman.botconstructor.convertor.perfomance;

import com.firstroman.botconstructor.dto.PerformanceDTO;
import com.firstroman.botconstructor.model.Performance;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConverterPerformanceDTOToPerformance implements Converter<PerformanceDTO, Performance> {
    @Override
    public Performance convert(PerformanceDTO performanceDTO) {
        Performance performance = new Performance();
        try {
            performance.setFile(performanceDTO.getFile().getBytes());
            performance.setFilename(performanceDTO.getFile().getOriginalFilename());
        } catch (IOException e) {
            System.out.println("Error write file");
        }
        performance.setCommand(performanceDTO.getCommand());
        performance.setMessage(performanceDTO.getMessage());
        performance.setId(performanceDTO.getId());
        return performance;
    }
}
