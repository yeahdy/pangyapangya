package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    //장바구니 목록 가져오기 - 필요 x
    /*public List<CartVO> getList();*/

    //장바구니 목록 가져오기
    public List<CartVO> getCartList(String userId);
    //장바구니 추가하기
    public void insertCart(CartVO cart);
    //장바구니 추가(pk가져오기)
    public void insertSelect_cartNum(CartVO cart);
    //장바구니 삭제
    public int deleteCart(Long cartNum);
    //수량(breadCnt) 수정
    public int updateBreadCnt(Long cartNum, int breadCnt);
    //장바구니 비우기
    public int emptyCart(String userId);
    //회원탈퇴 시 장바구니
    public int leaveUser_cart(String userId);
}
