package com.example.nshindarev.springfullappl.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer,Long> {
}
