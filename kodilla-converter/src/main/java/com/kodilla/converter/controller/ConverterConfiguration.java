package com.kodilla.converter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class ConverterConfiguration {

    @Bean
    public HttpMessageConverter<Object> customSlashConverter() {
        return new MyCustomSlashConverter();
    }

    @Bean
    public HttpMessageConverter<Object> customEnterConverter() {
        return new MyCustomEnterConverter();
    }
}
