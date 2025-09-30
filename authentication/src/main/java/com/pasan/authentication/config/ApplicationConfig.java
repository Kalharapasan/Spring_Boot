package com.pasan.authentication.config;

import com.pasan.authentication.user.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.print.attribute.UnmodifiableSetException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepositry userRepositry;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepositry.findByEmail(username)
                .orElseThrow(()->new UnmodifiableSetException("User not found"));
    }

}
