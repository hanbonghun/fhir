package com.skylabs.fhirdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FhirDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FhirDemoApplication.class, args);
    }
    
}
