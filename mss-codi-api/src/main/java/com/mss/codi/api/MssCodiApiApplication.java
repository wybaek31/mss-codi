package com.mss.codi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.mss.codi.core", "com.mss.codi.api"})
@SpringBootApplication
public class MssCodiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssCodiApiApplication.class, args);
    }

}
