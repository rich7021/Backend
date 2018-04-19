package rifu.demo.engqiz.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This class will be used for all integration test. All tests used this class should go a complete procedure, i.e.
 * from send a request to controller, service do the business logic, and dao get data from data resource. Therefore,
 * here we include all rifu.demo.engqiz.service and dao in core.o
 */
@Configuration
@ComponentScan(basePackages = {"rifu.demo.engqiz.service"})
@EnableJpaRepositories(basePackages = {"rifu.demo.engqiz.core.dao"})
public class ITApplicationConfig {
}
