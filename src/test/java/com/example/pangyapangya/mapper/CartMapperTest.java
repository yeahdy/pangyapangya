package com.example.pangyapangya.mapper;

import com.example.pangyapangya.mappers.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CartMapperTest {
    @Autowired
    CartMapper mapper;

    @Test
    public void testGetList(){
        mapper.getCartList().forEach(cart -> log.info(cart.toString()));
    }
}
