package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.CartDAO;
import com.example.pangyapangya.beans.vo.CartVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartDAO cartDAO;

    public void addCart(CartVO cart) {
        cartDAO.addCart(cart);
    }
    /*public List<CartVO> getCart(String userId){
        return cartDAO.getCart(userId);
    }*/
    //수정한 getCart
    public List<CartVO> getCartList(String userId){
        return cartDAO.getCart(userId);
    }

    public boolean deleteCart(Long cartNum){
        return cartDAO.deleteCart(cartNum);
    }
    public boolean updateCnt(Long cartNum, int breadCnt){
        return cartDAO.updateCnt(cartNum, breadCnt);
    }
    public boolean emptyCart(String userId){
        return cartDAO.emptyCart(userId);
    }
    public boolean leaveUser(String userId){
        return cartDAO.leaveUser(userId);
    }
}
