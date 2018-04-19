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
import rifu.demo.engqiz.service.TestApplicationConfig;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * If @WebAppConfiguration not annotated here, the WebApplicationContext will not load beans and context.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
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
        MvcResult result = this.mockMvc.perform(get("/questions")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.*", hasSize(2))).andReturn();
        assertEquals("", "");
    }

}
