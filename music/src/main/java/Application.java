import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yuanwj on 2017/1/18.
 */
@SpringBootApplication
@ComponentScan("com.yuanwj")
public class Application {
    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(Application.class);

        ConfigurableApplicationContext context=application.run();
    }
}
