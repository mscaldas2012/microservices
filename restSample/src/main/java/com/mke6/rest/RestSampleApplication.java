package com.mke6.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class RestSampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestSampleApplication.class, args);
  }
}
