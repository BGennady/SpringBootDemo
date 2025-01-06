package ru.netology.SpringBootDemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//профилей больше одного, то подключается конфигурационный класс JavaConfig
//и определяет какой бин подкоючить
@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    SystemProfile devProfile (){
        return new DevProfile();
    }
    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    SystemProfile productionProfile () {
        return new ProductionProfile();
    }
}
