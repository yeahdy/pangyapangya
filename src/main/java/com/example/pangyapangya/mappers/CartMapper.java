package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    //장바구니 목록 가져오기
    public List<CartVO> getCartList();
}
