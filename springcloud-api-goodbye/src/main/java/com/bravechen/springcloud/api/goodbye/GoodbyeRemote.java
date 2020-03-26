package com.bravechen.springcloud.api.goodbye;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author brave
 */
@FeignClient(name = "spring-cloud-goodbye", fallback = GoodbyeRemoteHystrix.class)
public interface GoodbyeRemote {
    @GetMapping("/goodbye/{name}")
    public String goodbye(@PathVariable String name);
}
