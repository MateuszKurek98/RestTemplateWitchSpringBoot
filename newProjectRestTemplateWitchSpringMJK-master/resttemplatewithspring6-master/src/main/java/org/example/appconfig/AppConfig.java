package org.example.appconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Objects;

@Configuration
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yamlProperties = new YamlPropertiesFactoryBean();
        yamlProperties.setResources(new ClassPathResource("application.yml"));
        propertyConfigurer.setProperties(Objects.requireNonNull(yamlProperties.getObject()));
        return propertyConfigurer;
        }
        @Bean
        public ObjectMapper objectMapper(){
            return new ObjectMapper();
        }
    }
