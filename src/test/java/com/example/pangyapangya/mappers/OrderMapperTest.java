package com.example.pangyapangya.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OrderMapperTest {
    @Autowired
    private OrderMapper mapper;

@Test
    public void testGetOrderList() throws Exception{
        mapper.getOrderList("kjyun7777").forEach(order -> log.info(order.toString()));
    }
}
