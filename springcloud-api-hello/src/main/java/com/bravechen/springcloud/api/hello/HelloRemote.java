package com.bravechen.springcloud.api.hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author brave
 */
@FeignClient(name = "spring-cloud-hello", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name);
}