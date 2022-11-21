package com.example.nshindarev.springfullappl.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command line runner");
        };
    }


    // allows not to use qualifier tag
    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustoerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
