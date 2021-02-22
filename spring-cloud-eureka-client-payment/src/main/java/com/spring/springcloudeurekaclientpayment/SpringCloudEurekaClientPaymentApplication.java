package com.spring.springcloudeurekaclientpayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class SpringCloudEurekaClientPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientPaymentApplication.class, args);
	}

}
