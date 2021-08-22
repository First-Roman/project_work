package com.firstroman.botconstructor.service.customer;

import com.firstroman.botconstructor.convertor.customer.ConverterCustomerToCustomerDTO;
import com.firstroman.botconstructor.dto.CustomerDTO;
import com.firstroman.botconstructor.model.Customer;
import com.firstroman.botconstructor.model.UserPreference;
import com.firstroman.botconstructor.repository.customer.CustomerRepository;
import com.firstroman.botconstructor.repository.preference.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@SessionScope
public class CustomerServiceMongo implements CustomerService {

    private final CustomerRepository customerRepository;

    private final UserPreferenceRepository userPreferenceRepository;

    private final ConverterCustomerToCustomerDTO convert;

    private String affiliation;

    @Override
    public List<CustomerDTO> getCustomers() {
        if (affiliation == null) {
            String login = SecurityContextHolder.getContext().getAuthentication().getName();
            UserPreference userPreference = userPreferenceRepository.findByLogin(login);
            affiliation = userPreference.getUserToken();
        }
        List<Customer> customers = customerRepository.findAllByAffiliationId(affiliation);
        List<CustomerDTO> customerDTOS = customers.stream().map(customer -> convert.convert(customer)).collect(Collectors.toList());
        return customerDTOS;
    }
}
