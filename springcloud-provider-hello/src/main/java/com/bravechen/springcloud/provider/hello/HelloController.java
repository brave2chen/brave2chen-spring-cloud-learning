package com.bravechen.springcloud.provider.hello;

import com.bravechen.springcloud.api.goodbye.GoodbyeRemote;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brave
 */
@RestController
public class HelloController {
    private GoodbyeRemote goodbyeRemote;

    public HelloController(GoodbyeRemote goodbyeRemote) {
        this.goodbyeRemote = goodbyeRemote;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Nice to meet you, " + name;
    }

    @GetMapping("/goodbye/{name}")
    public String goodbye(@PathVariable String name) {
        return goodbyeRemote.goodbye(name);
    }
}
