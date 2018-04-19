package rifu.demo.engqiz.service.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rifu.demo.engqiz.service.ITApplicationConfig;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @implNote Integration Test Example File
 * This is an integration test example. The @WebAppConfiguration will load all application needs beans and
 * configurations based on what we set in @ContextConfiguration. Then, we get context via autowire
 * WebApplicationContext and make it build into mockMvc in the setUp method. Consequently, when we use mockMvc
 * .perform(), it will follow the context to go through all the application procedure.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ITApplicationConfig.class})
@WebAppConfiguration
public class QuestionControllerIT {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFindAllQuestion() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/questions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)))
                .andReturn();
    }
}
