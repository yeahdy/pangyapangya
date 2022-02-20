package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private String userId;
    private String userPw;
    private String userName;
    private String userZipcode;
    private String userAddress;
    private String userAddressdetail;
    private String userPhoneNum;
    private int status;
    private int applyCnt;
}
