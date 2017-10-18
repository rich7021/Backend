package richard.demo.springwebapplication;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {


    @Autowired
    HelloService helloService;

    @Test
    public void testGetHello() {
        String str = helloService.getHello();
        assertThat(str, is("Hello World!!"));
    }
}
