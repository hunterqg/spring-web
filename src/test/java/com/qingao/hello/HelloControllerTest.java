package com.qingao.hello;

import com.qingao.hello.controller.HelloController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {MyConfig.class})
@SpringApplicationConfiguration(classes = {/*MyConfig.class,*/MockServletContext.class,})
@WebAppConfiguration
public class HelloControllerTest {

    private MockMvc mvc;

    @Mock
    private Environment env;

    @InjectMocks
    private HelloController helloController;
    @Autowired
    protected ApplicationContext ctx;
    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
/*
    @Test
	public void getHello2() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("hello")));
	}
*/

    @Test
    public void getConfig() throws  Exception{
        Mockito.when(env.getProperty("key_seven")).thenReturn("seven");
        mvc.perform(MockMvcRequestBuilders.get("/cfg").accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("seven")));
    }
}
