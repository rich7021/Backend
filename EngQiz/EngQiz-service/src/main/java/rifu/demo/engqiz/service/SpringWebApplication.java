package rifu.demo.engqiz.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableJpaRepositories(
        basePackages = {
                "rifu.demo.engqiz.core.dao"
        }
)
@EntityScan("rifu.demo.engqiz.core.entity")
@ComponentScan({"rifu.demo.engqiz.core.dao", "rifu.demo.engqiz.service.*"})
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }
}
