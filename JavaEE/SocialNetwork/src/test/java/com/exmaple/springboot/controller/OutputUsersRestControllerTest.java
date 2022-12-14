package com.exmaple.springboot.controller;

import com.exmaple.springboot.config.jwt.Jwt;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class OutputUsersRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Jwt jwt;

    @Test
    public void shouldReturnA403WhenUserIsNotLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/users")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isForbidden());
    }

    @WithMockUser(username="Denis",roles={"USER","ADMIN"})
    @Test
    public void shouldReturnA403WhenUserIsLoggedIn() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/users")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
