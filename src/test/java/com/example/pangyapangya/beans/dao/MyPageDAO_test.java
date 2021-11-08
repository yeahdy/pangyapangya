package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MyPageDAO_test {
    @Autowired
    private TestingDAO testingDAO;

    /*@Test
    public void testAddCart() throws Exception{
        CartVO cart = new CartVO();
        cart.setBreadName("빵3");
        cart.setUserId("kjy12345");
        cart.setPriceOfBread(11000);
        cart.setDeliverCharge(3000);
        cart.setBreadCnt(3);
        cart.setBreadImg("bread1.jpg");
        cart.setCeoId("A");
        cartDAO.addCart(cart);
    }*/

    @Test
    public void testGetCart() throws Exception{
        testingDAO.getTestingReview("kjyun7777").forEach(review ->log.info(review.toString()));
    }

}
