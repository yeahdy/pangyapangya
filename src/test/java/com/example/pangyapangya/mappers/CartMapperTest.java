package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CartVO;
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

    /*모든 사용자 장바구니 목록*/
    /*@Test
    public void testGetList() {
        mapper.getList().forEach(cart -> log.info(cart.toString()));
    }*/

    /*사용자 개인 장바구니*/
    @Test
    public void testGetCartList() {
        mapper.getCartList("kjy1234").forEach(cart -> log.info(cart.toString()));
    }

/*    @Test
    public void testInsertCart() {
        CartVO cart = new CartVO();
        cart.setUserId("kjy1234");
        cart.setBreadName("제멋대로 쿠기");
        cart.setBreadImg("images/bread1.jpg");
        cart.setBreadCnt(1);
        cart.setDeliverCharge(3000);
        cart.setPriceOfBread(1000);
        mapper.insertCart(cart);
    }*/

    @Test
    public void testInsertSelect_cartNum() {
        CartVO cart = new CartVO();
        cart.setUserId("hds1234");
        cart.setBreadName("쫀득 찹쌀빵");
        /*겉바속촉 크루와상🥐*/
        cart.setBreadImg("images/bread1.jpg");
        cart.setBreadCnt(1);
        cart.setDeliverCharge(3000);
        cart.setPriceOfBread(13000);
        mapper.insertSelect_cartNum(cart);
    }

    @Test
    public void testDeleteCart(){
        int result = mapper.deleteCart(10L);
        if (result ==0) {
            log.info("장바구니에서 해당항목을 찾을 수 없습니다.");
        }
        mapper.getCartList("kjy1234");
    }

    @Test
    public void testUpdateBreadCnt() {
        int result = mapper.updateBreadCnt(12L, 10);
        if (result==0) {
            log.info("장바구니에서 해당항목을 찾을 수 없습니다.");
        }
        mapper.getCartList("kjy1234");
    }

    @Test
    public void testLeaveUser_cart(){
        int result = mapper.leaveUser_cart("kjy1234");
        if (result==0){
            log.info("존재하지 않는 회원입니다.");
        }
    }
}
