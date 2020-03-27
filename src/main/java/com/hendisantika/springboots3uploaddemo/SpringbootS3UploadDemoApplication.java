package com.hendisantika.springboots3uploaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootS3UploadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootS3UploadDemoApplication.class, args);
    }

}
