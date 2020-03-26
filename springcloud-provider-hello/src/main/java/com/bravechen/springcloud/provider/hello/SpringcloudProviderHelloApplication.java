package com.bravechen.springcloud.provider.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author brave
 */
@SpringBootApplication(scanBasePackages = "com.bravechen.springcloud")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.bravechen.springcloud.api")
@EnableHystrix
public class SpringcloudProviderHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderHelloApplication.class, args);
    }

}
