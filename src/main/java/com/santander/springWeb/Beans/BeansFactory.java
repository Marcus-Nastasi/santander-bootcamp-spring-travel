package com.santander.springWeb.Beans;

import com.santander.springWeb.Models.Destiny;
import com.santander.springWeb.Models.Reserve;
import com.santander.springWeb.Models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansFactory {

    @Bean
    public User user() {
        return new User();
    }
    @Bean
    public Reserve reserve() {
        return new Reserve();
    }
    @Bean
    public Destiny destiny() {
        return new Destiny();
    }
}



