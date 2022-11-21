package com.example.nshindarev.springfullappl.customer;

import com.example.nshindarev.springfullappl.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class CustomerService {

    private final CustomerRepo customerRepo;


    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getCustomer(Long id){
        return  getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("customer with id " + id + " not found"));
    }
    public List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }
}
