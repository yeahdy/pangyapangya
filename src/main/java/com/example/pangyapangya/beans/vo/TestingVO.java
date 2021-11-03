package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingVO {
    private Long tno;
    private String startDate;
    private String endDate;
    private String ceoId;
    private String title;
    private String breadType;
    private String breadName;
    private int breadPrice;
    private int people;
    private String description;
    private String testingPhoto;
    private String regDate;
}