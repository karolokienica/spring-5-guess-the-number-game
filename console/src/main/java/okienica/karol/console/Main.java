package okienica.karol.console;

import lombok.extern.slf4j.Slf4j;
import okienica.karol.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess the number game");

//        create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

//        close context (container)
        context.close();
    }
}
