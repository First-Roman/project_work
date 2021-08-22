package com.firstroman.botconstructor.convertor.customer;

import com.firstroman.botconstructor.dto.CustomerDTO;
import com.firstroman.botconstructor.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterCustomerToCustomerDTO implements Converter<Customer, CustomerDTO> {
    @Override
    public CustomerDTO convert(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setInsertDate(customer.getInsertDate());
        customerDTO.setTelegramId(customer.getTelegramId());
        customerDTO.setTelegramUsername(customer.getTelegramUsername());
        return customerDTO;
    }
}
