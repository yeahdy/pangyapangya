package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data
public class CartVO {
    private Long cartNum;
    private String userId;
    private String breadName;
    private int priceOfBread;
    private int deliverCharge;
    private int breadCnt;
    private String breadImg;
    private String ceoId;
    private String shopName;
}
