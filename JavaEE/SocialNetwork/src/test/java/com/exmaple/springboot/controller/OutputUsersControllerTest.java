package com.exmaple.springboot.controller;

import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.UserService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class OutputUsersControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void shouldExistsUsers() throws Exception {
        List<User> testUserList = new ArrayList<>();
        testUserList.add(User.builder().userId(1).login("Denis").password("1111").build());
        testUserList.add(User.builder().userId(2).login("German").password("1111").build());

        BDDMockito.given(userService.getUserFromPage(null, null)).willReturn(testUserList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string(StringContains.containsString("<span>Denis</span>")))
                .andExpect(content().string(StringContains.containsString("<span>German</span>")));
    }
}
