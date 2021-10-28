package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BakeryVO {
    private Long bno;
    private String content;
    private String title;
    private String ceoId;
    private String bakeryName;
    private String bakeryZipCode;
    private String bakeryAddress;
    private String bakeryAddressDetail;
    private String bakeryPhoto;
    private String regDate;
}
