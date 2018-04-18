package rifu.demo.engqiz.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
// due to dao and entity are not in the same package, so we explicitly assign the package
@EnableJpaRepositories(basePackages = {"rifu.demo.engqiz.core.dao"})
@EntityScan("rifu.demo.engqiz.core.entity")
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }
}
