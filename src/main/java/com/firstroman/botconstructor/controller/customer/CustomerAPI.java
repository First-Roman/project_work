package com.firstroman.botconstructor.controller.customer;

import com.firstroman.botconstructor.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CustomerAPI {
    private final CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }
}
