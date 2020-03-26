package com.bravechen.springcloud.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
@EnableAdminServer
public class SpringcloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMonitorApplication.class, args);
    }

}
