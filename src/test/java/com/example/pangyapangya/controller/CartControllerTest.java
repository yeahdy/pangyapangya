package com.example.pangyapangya.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class CartControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCartList() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/mypage/cart")).andReturn().getModelAndView().getModelMap().toString());
    }
    @Test
    public void testAddCart() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/mypage/cart")
                .param("breadName", "빵33")
                .param("userId","hds1234")
                .param("deliverCharge", "3000")
                .param("breadCnt","4")
                .param("breadImg", "bread1.jpg")
        ).andReturn();


    }
}
