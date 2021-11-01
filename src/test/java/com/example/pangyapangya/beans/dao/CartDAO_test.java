package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CartDAO_test {
    @Autowired
    private CartDAO cartDAO;

    @Test
    public void testAddCart() throws Exception{
        CartVO cart = new CartVO();
        cart.setBreadName("빵3");
        cart.setUserId("kjy1234");
        cart.setPriceOfBread(11000);
        cart.setDeliverCharge(3000);
        cart.setBreadCnt(3);
        cart.setBreadImg("이미지1");
        cart.setCeoId("A");
        cartDAO.addCart(cart); 
    }

    @Test
    public void testGetCart() throws Exception{
        cartDAO.getCart("kjy1234").forEach(cart ->log.info(cart.toString()));
    }

    @Test
    public void testDeleteCart() throws Exception{
        if (!cartDAO.deleteCart(22l)){
            log.info("-------------------------------------");
            log.info("해당 상품이 담겨있지 않습니다.");
            log.info("-------------------------------------");
        }
    }

    @Test
    public void testUpdateCnt() throws Exception{
        if (!cartDAO.updateCnt(23L, 5)){
            log.info("-------------------------------------");
            log.info("해당 상품이 담겨있지 않습니다.");
            log.info("-------------------------------------");
        }
    }

    @Test
    public void tstLeaveUser() throws Exception {
        if (cartDAO.leaveUser("hds1234")) {
            log.info("-------------------------------------");
            log.info("장바구니가 모두 비워졌습니다.");
            log.info("-------------------------------------");
        }
    }
}
