package com.example.nshindarev.springfullappl.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        // we may mock it | bring real dependency @JPATest
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomer() {
        // given
        Customer jamilia = new Customer(1L, "jamilia", "hello", "jamilia@gmail.com");

        customerRepository.save(jamilia);

        // when
        Customer actual = underTest.getCustomer(1L);

        // then
        assertEquals(1L, actual.getId());
        assertEquals("jamilia@gmail.com", actual.getEmail());
        assertEquals("jamilia", actual.getName());
        assertEquals("hello", actual.getPassword());
    }

    @Test
    void getCustomers() {
        // given
        Customer jamilia = new Customer(1L, "jamilia", "hello", "jamilia@gmail.com");
        Customer ali = new Customer(2L, "ali", "hello", "ali@gmail.com");

        customerRepository.saveAll(Arrays.asList(jamilia, ali));

        // when
        List<Customer> customers = underTest.getCustomers();

        // then
        assertEquals(2, customers.size());
    }
}
