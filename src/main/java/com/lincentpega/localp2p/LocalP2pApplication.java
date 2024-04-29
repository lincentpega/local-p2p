package com.lincentpega.localp2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LocalP2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalP2pApplication.class, args);
    }

}
