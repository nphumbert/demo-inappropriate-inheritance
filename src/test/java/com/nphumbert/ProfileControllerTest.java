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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InappropriateInheritanceApplication.class)
@WebAppConfiguration
public class ProfileControllerTest {

    private MockMvc mockMvc;
    private HashProvider hashProvider;

    @Before
    public void setUp() {
        hashProvider = mock(HashProvider.class);
        ProfileController controller = new ProfileController(hashProvider);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void should_get_hash_when_get_profile() throws Exception {
        // given
        when(hashProvider.hash("profile")).thenReturn("hash");

        // when
        String contentAsString = mockMvc.perform(get("/profile"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // then
        assertThat(contentAsString, is("profile: hash"));
    }
}