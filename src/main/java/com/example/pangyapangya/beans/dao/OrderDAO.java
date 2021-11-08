package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.OrderVO;
import com.example.pangyapangya.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository /*부모가 component*/
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper mapper;

    public List<OrderVO> getOrderList(String userId){
        return mapper.getOrderList(userId);
    }
}
