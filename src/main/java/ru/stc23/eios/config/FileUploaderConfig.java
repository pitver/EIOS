package ru.stc23.eios.config;

/**
 * @author Matveev
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;


@Configuration
@ComponentScan
@EnableAutoConfiguration
public class FileUploaderConfig {

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("5MB"));
        factory.setMaxRequestSize(DataSize.parse("5MB"));
        return factory.createMultipartConfig();
    }





}