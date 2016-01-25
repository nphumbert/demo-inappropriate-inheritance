package com.nphumbert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InappropriateInheritanceApplication.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        UserController controller = new UserController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void should_get_hash_when_get_user() throws Exception {
        // when
        String contentAsString = mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThat(contentAsString, is("user: [4, -8, -103, 109, -89, 99, -73, -87, 105, -79, 2, -114, -29, 0, 117, 105, -22, -13, -90, 53, 72, 109, -38, -78, 17, -43, 18, -56, 91, -99, -8, -5]"));
    }
}