package com.example.nshindarev.springfullappl.customer;

import com.example.nshindarev.springfullappl.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomer(Long id){
        return  customerRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("customer with id " + id + " not found"));
    }
    public List<Customer> getCustomers(){
        log.debug("getCustomers metod is called");
        return customerRepository.findAll();
    }
}
