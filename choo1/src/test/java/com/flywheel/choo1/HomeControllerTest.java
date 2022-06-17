package com.flywheel.choo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author yekw
 * @date 2022/6/16/19:47
 * @description:
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    @Resource
    private MockMvc mockMvc;


    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))    // <3>
                .andExpect(status().isOk())  // <4>
                .andExpect(view().name("home"))  // <5>
                .andExpect(content().string(           // <6>
                        containsString("Welcome to...")));
    }
}
