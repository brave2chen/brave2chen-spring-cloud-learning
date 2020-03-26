package com.bravechen.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@RestController
public class SpringcloudGatewayApplication {
    @GetMapping("/fallback")
    public String fallback(){
        return "fallback";
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayApplication.class, args);
    }

}
