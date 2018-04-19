package rifu.demo.engqiz.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used by all controller unit test.
 * Due to we just want to test controller functionality, instead of how it go through service and dao, and even data
 * source, here we just scan controller package, in order to speed up the test process.
 */
@Configuration
@ComponentScan(basePackages = {"rifu.demo.engqiz.service.controller"})
public class TestApplicationConfig {
}
