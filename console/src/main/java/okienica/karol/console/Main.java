package okienica.karol.console;

import okienica.karol.config.AppConfig;
import okienica.karol.MessageGenerator;
import okienica.karol.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

//        create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class)/*ClassPathXmlApplicationContext(CONFIG_LOCATION)*/;

        //        get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(/*"numberGenerator",*/ NumberGenerator.class);

//        call method next() to get a random number
        int number = numberGenerator.next();

//        log generated number
        log.info("number = {}", number);
//        log.info(new MessageGeneratorImpl().getMainMessage());

//        get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

//        call reset method
//        game.reset();

//        close context (container)
        context.close();
    }
}
