package com.example.nshindarev.springfullappl.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers(){
        return Arrays.asList(new Customer(1L, "James Bond", "000"),
                new Customer(2L, "Jamilia", "123"),
                new Customer(3L, "Ahmed", "1234"));
    }
}
