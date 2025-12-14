package com.baeldung.ls.config;

import com.baeldung.ls.persistence.model.BeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    BeanA beanA() {
        return new BeanA();
    }

    @Bean
    static MyBeanPostProcessor beanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
