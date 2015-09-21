package unit;

import hello.GreetingController;
import org.junit.*;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GreetingControllerTest {
    @InjectMocks GreetingController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        controller = new GreetingController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
            .setViewResolvers(new ThymeleafViewResolver())
            .build();
    }

    @Test
    public void testGreeting() throws Exception {
        System.out.println("******");
        System.out.println(mockMvc);
        System.out.println("******");

        mockMvc.perform(get("/greeting?name=James"))
            .andExpect(status().isOk());
//            .andExpect(model().attribute("name", "James"))
//            .andExpect(view().name("greeting"));
    }
}
