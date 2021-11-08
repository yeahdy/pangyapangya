package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.OrderDAO;
import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.beans.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDAO orderDAO;

    public List<OrderVO> getOrderList(String userId){
        return orderDAO.getOrderList(userId);
    }
}
