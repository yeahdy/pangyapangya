package com.example.pangyapangya.mappers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CartMapperTest {

    @Autowired
    private BakeryMapper mapper;

    /*@Autowired
    CartMapper mapper;

   *//* @Test
    public void testGetList(){
        mapper.getList().forEach(cart -> log.info(cart.toString()));
    }*//*
    @Test
    public void testGetTime(){
        String sysdate = mapper.getTime();
        log.info("---------------------------------------");
        log.info("sysdate : " + sysdate);
        log.info("---------------------------------------");
    }*/
}
