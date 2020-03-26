package com.bravechen.springcloud.api.goodbye;

import org.springframework.stereotype.Component;

/**
 * @author brave
 */
@Component
public class GoodbyeRemoteHystrix implements GoodbyeRemote {

    @Override
    public String goodbye(String name) {
        return "/goodbye/" + name + ", this message send failed.";
    }
}
