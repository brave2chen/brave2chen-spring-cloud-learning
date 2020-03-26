package com.bravechen.springcloud.provider.goodbye;

import com.bravechen.springcloud.api.hello.HelloRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brave
 */
@RestController
public class GoodbyeController {
    private HelloRemote helloRemote;

    public GoodbyeController(HelloRemote helloRemote) {
        this.helloRemote = helloRemote;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloRemote.hello(name);
    }

    @GetMapping("/goodbye/{name}")
    public String goodbye(@PathVariable String name) {
        return "Bye Bye, " + name;
    }
}
