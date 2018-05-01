package rifu.demo.mybatisspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import rifu.demo.mybatisspring.config.DataSource1Config;

@SpringBootApplication
@Import(DataSource1Config.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
