package rifu.demo.engqiz.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @ComponetScan basepackages set here because we only test services, not core.
 */
@Configuration
@ComponentScan(basePackages = {"rifu.demo.engqiz.service"})
@EnableJpaRepositories(basePackages = {"rifu.demo.engqiz.core.dao"})
public class TestApplicationConfig {
}
