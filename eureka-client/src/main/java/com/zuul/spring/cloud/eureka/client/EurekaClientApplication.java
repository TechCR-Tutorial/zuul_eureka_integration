package com.zuul.spring.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication implements GreetingController {

//    @Autowired
//    @Lazy
//    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    public String greeting() {
        System.out.println("Request received on port number " + portNumber);
//        return String.format("Hello from '%s with Port Number %s'!", eurekaClient.getApplication(appName)
//                .getName(), portNumber);
        return String.format("Hello from '%s with Port Number %s'!", appName, portNumber);
    }
}