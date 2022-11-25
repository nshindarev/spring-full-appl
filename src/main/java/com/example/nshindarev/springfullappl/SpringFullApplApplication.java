package com.example.nshindarev.springfullappl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
public class SpringFullApplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFullApplApplication.class, args);
	}

}
