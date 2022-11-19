package com.example.nshindarev.springfullappl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping
    public void createNewCustomer(@RequestBody Customer customer){
        System.out.println("create ..." + customer.toString());
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        System.out.println("Delete " + customerId);
    }


    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        System.out.println("UPDATE ..." + customer.toString());
    }
}
