package com.bravechen.springcloud.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationConfiguration authenticationConfiguration;
    private final UserDetailsService userDetailsService;

    public OAuth2AuthorizationServerConfig(AuthenticationConfiguration authenticationConfiguration, UserDetailsService userDetailsService) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder builder = clients
                .inMemory().withClient("client");
        builder.secret("secret")
//                .resourceIds()
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
//                .authorities(AuthorityUtils.authorityListToSet().toArray(new String[0]))
                .scopes("select", "update", "add", "delete");

//        builder.autoApprove(this.details.getAutoApproveScopes().toArray(new String[0]));
//        builder.accessTokenValiditySeconds(this.details.getAccessTokenValiditySeconds());
//        builder.refreshTokenValiditySeconds(this.details.getRefreshTokenValiditySeconds());

        builder.redirectUris("http://localhost:8787/user");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(NoOpPasswordEncoder.getInstance());
        security.checkTokenAccess("permitAll()");
        security.tokenKeyAccess("permitAll()");
        security.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(new DefaultAccessTokenConverter());
        endpoints.tokenStore(new InMemoryTokenStore());
        endpoints.userDetailsService(userDetailsService);
        endpoints.authenticationManager(this.authenticationConfiguration.getAuthenticationManager());
    }
}