package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.mappers.CartMapper;
import lombok.RequiredArgsConstructor;
import com.example.pangyapangya.beans.vo.CartVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository /*부모가 component*/
@RequiredArgsConstructor
public class CartDAO {
    private final CartMapper mapper;

    public void addCart(CartVO cart){
        mapper.insertSelect_cartNum(cart);
    }

    public List<CartVO> getCart(String userId){
       return mapper.getCartList(userId);
    }

    public boolean deleteCart(Long cartNum){
        return mapper.deleteCart(cartNum)==1;
    }

    public boolean updateCnt(Long cartNum, int breadCnt){
        return mapper.updateBreadCnt(cartNum, breadCnt)==1;
    }

    public boolean emptyCart(String userId){
        return mapper.leaveUser_cart(userId)==1;
    }

    public boolean leaveUser(String userId){
        return mapper.leaveUser_cart(userId)==1;
    }

}
