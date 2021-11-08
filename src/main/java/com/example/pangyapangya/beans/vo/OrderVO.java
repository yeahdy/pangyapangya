package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private int orderNum;
    private Long bno;
    private String userId;
    private int breadNum;
    private String status;
    private int payment;
    private String orderDate;
    private int deliveryNum;
    private int breadCnt;
}
