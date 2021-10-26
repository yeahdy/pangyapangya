package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClassCeoVO {
    private Long bno;
    private String title;
    private String ceoId;
    private String classPhoto;
    private int classPrice;
    private String regDate;
    private String endDate;
    private String classDate;
    private int recruitment;
    private String description;
    private String bakeryName;
    private String bakeryZipCode;
    private String bakeryAddress;
    private String bakeryAddressDetail;
}
