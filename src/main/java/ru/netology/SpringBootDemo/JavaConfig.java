package ru.netology.SpringBootDemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    SystemProfile devProfile (){
        return new DevProfile();
    }
    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "falce")
    SystemProfile productionProfile () {
        return new ProductionProfile();
    }
}
