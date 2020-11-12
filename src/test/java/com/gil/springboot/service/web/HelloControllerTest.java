package com.gil.springboot.service.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // connect between springboot and junit
@WebMvcTest(controllers = HelloController.class) // Annotation that concentrate on Web(Spring MVC) - @Controller, @ControllerAdvice
public class HelloControllerTest {

    @Autowired // inject bean
    private MockMvc mvc; // start point of spring mvc test. use to web api test

    @Test public void hello가_리턴된다()  throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // request get
                .andExpect(status().isOk()) // verify result from response status code
                .andExpect(content().string(hello)); // verify result from response content

    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").
                param("name",name).
                param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount))); // jsonpath method is verify response data of json
    }

}
