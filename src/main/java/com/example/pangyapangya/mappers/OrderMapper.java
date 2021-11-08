package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.beans.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    //주문 목록 가져오기
    public List<OrderVO> getOrderList(String userId);
}
