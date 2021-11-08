package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.TestingReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestingMapperTest {
    @Autowired
    private TestingMapper mapper;

    @Test
    public void testGetTestingReview() throws Exception{
        mapper.getTestingReview("kjyun7777").forEach(order -> log.info(order.toString()));
    }
}
