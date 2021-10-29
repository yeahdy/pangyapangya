package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CeoVO {
    private String ceoId;
    private String ceoPw;
    private String ceoName;
    private String shopName;
    private String shopCallNumber;
    private String shopZipcode;
    private String shopAddress;
    private String shopAddressDetail;
    private String shopPhoto;
    private String phoneNum;
    private String shopRegNum;
    private int status;
}
