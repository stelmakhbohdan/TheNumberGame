package myAcademy.learning.console;

import myAcademy.learning.config.AppConfig;
import myAcademy.learning.MessageGenerator;
import myAcademy.learning.NumberGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log= LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The number game");

        ConfigurableApplicationContext context
                =new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerate numberGenerator
                =context.getBean(NumberGenerate.class);
        int number = numberGenerator.next();
        log.info("number = {}" , number);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage {}",messageGenerator.getMainMessage());
        log.info("getResultMessage {}",messageGenerator.getResultMessage());

        context.close();
    }
}
