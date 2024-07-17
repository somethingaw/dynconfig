package com.github.somethingaw.dynconfigtest.config;

import com.github.somethingaw.dynconfigtest.dto.TestProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TestConfig
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/9 9:20
 **/
@Configuration
public class TestConfig {

    @ConfigurationProperties(prefix = "test")
    @Bean(value = "test", destroyMethod = "preDestroy")
    public TestProperty modelProperties() {
        return new TestProperty();
    }
}
