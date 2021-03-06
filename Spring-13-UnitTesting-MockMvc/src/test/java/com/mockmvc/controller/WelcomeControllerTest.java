package com.mockmvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void welcome() throws Exception {

        // call /welcome end point
        // verify "welcome" displayed

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("welcome",result.getResponse().getContentAsString());
    }

    @Test
    void welcome2() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome2"))
                .andReturn();
    }

}