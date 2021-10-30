package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingVO {
    private Long tno;
    private Long tbno;
    private String startDate;
    private String endDate;
    private int cnt;
    private String ceoId;
    private String title;
    private String ceoName;
    private String shopCallNum;
    private String breadType;
    private String breadName;
    private int breadPrice;
    private int people;
    private String description;
    private String testingPhoto;
    private String shopName;
}
