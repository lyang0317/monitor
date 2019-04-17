/*package com.pharmaking.order.common.config;

import com.pharmaking.groundhog.passport.web.security.AnonymousAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages="com.pharmaking.groundhog.passport")
public class AuthOrderConfig {

    @Value("${urls:default}")
    private String urls;

    @Bean
    public AnonymousAuthentication getAnonymousAuthentication(){
        AnonymousAuthentication authentication = new AnonymousAuthentication();
        if(!urls.equals("default")) {
            List<String> urlSplit = Arrays.asList(urls.split(",|,"));
            StringBuilder sb = new StringBuilder();
            for (String url : urlSplit) {
                sb.append(url+ "\n");
            }

            authentication.setAnonymousPathDefinitions(sb.toString());
        }
        return authentication;
    }

}*/

