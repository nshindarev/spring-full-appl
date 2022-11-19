package com.example.nshindarev.springfullappl.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id)
    }

    @PostMapping
    public void createNewCustomer(@Valid @RequestBody Customer customer){
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
