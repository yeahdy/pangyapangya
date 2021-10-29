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
    public void testAddCart(){
        CartVO cart = new CartVO();
        cart.setBreadName("빵1");
        cart.setUserId("kjy1234");
        cart.setPriceOfBread(11000);
        cart.setDeliverCharge(3000);
        cart.setBreadCnt(3);
        cart.setBreadImg("이미지1");
        cartDAO.addCart(cart); 
    }

    @Test
    public void testGetCart(){
        /*cartDAO.getCart("kjy1234").forEach(cart ->log.info(cart.toString()));*/
        if (cartDAO.getCart("kjy1234").toString()==null){
            log.info("장바구니에 상품이 없습니다.");
        };
    }

    /*@Test
    public void testDeleteCart{
        cartDAO.deleteCart()
    }*/
}
