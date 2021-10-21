package com.example.pangyapangya.mapper;

import com.example.pangyapangya.beans.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    /*//장바구니 목록 가져오기
    public List<CartVO> getList();*/
    //시간 가져오기
    public String getTime();
}
