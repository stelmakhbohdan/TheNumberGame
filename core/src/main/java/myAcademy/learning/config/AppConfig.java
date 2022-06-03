package myAcademy.learning.config;

import myAcademy.learning.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "myAcademy.learning")
public class AppConfig {
    @Bean
    public NumberGenerate numberGenerate() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
