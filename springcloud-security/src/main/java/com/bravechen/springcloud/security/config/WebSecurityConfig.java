package com.bravechen.springcloud.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <code>WebSecurity配置</code> 不要和 <code>ResourceServer配置</code> 共用
 * 这会导致<code>formLogin</code>失效，因为<code>SecurityContextRepository</code>是共用的
 * <code>ResourceServer配置</code>使用<code>NullSecurityContextRepository</code>，
 * 也就是不存储认证信息，导致<code>formLogin</code>失效
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
            .antMatchers("/code").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().and()
            .rememberMe().and()
            .httpBasic();
        // @formatter:on
    }
}
