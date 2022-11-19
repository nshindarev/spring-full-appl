package com.example.nshindarev.springfullappl.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CustomerRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers(){

        // TODO: connect to DB
        return Collections.emptyList();
    }

}
