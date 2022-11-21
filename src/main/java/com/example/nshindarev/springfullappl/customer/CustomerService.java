package com.example.nshindarev.springfullappl.customer;

import com.example.nshindarev.springfullappl.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id){
        return  customerRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("customer with id " + id + " not found"));
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
