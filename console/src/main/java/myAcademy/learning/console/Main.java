package myAcademy.learning.console;

import lombok.extern.slf4j.Slf4j;
import myAcademy.learning.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess The number game");

        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);
        Stream.of(context.getBeanDefinitionNames())
                .forEach(beanName -> System.out.println(" - "+ beanName));
        context.close();
    }
}
