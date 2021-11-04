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
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/mypage/cartList")).andReturn().getModelAndView().getModelMap().toString());
    }
    @Test
    public void testAddCart() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/mypage/addCart")
                .param("breadName", "초코 까눌레")
                /*초코듬뿍 까눌레*/
                /*겉바속촉 크루와상*/
                .param("userId","yejine000")
                .param("PriceOfBread","10500")
                .param("deliverCharge", "3000")
                .param("breadCnt","3")
                .param("breadImg", "croissant1.jpg")
                .param("ceoId","dhodkseho")
        ).andReturn();

    }

    @Test
    public void testGetCart() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/mypage/cart").param("userId", "hds1234")).andReturn().getModelAndView().getViewName());
    }

    @Test
    public void testDeleteCart() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/mypage/deleteCart").param("cartNum","1"))
                .andReturn().getFlashMap().toString();
        log.info(result);
    }

    @Test
    public void testUpdateCnt() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/mypage/updateCnt").param("cartNum", "36").param("breadCnt","7"))
                .andReturn().getFlashMap().toString();
        log.info(result);

    }
}
