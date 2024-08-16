package com.mss.codi.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.mss.codi.core", "com.mss.codi.admin"})
@SpringBootApplication
public class MssCodiAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssCodiAdminApplication.class, args);
    }

}
