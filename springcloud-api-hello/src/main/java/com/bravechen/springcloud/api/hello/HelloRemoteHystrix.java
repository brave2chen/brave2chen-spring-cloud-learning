package com.bravechen.springcloud.api.hello;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author brave
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "/hello/name=" + name + ", this message send failed.";
    }
}