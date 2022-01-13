package sia.tacocloud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest()
//* arranges for the test to run in the context of a Spring MVC app. Requests can be thrown at it
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; //*  helps us to start the in-memory servlet container & check that the right controller methods are invoked & then the right responses have been coming out

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))       //* calls the method in teh controller annotated with the @GetMapping and with the specified path
                .andExpect(status().isOk())         //* verifies that the response is 200 (ok)
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Hi! Welcome to ...")));
    }

}
