package com.firstroman.botconstructor.controller.performance;

import com.firstroman.botconstructor.dto.PerformanceDTO;
import com.firstroman.botconstructor.service.performance.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PerformanceAPI {

    private final PerformanceService performanceService;

    @GetMapping(value = "/performance")
    public ResponseEntity getPerformance(@RequestParam String command) {
        return ResponseEntity.ok().body(performanceService.getPerformanceByCommand(command));
    }

    @PostMapping(value = "/performance", consumes = {"multipart/form-data"})
    public ResponseEntity setPerformance(PerformanceDTO performanceDTO) {
        performanceService.savePerformance(performanceDTO);
        return ResponseEntity.ok().build();
    }
}
