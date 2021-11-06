package com.example.pangyapangya.beans.vo;

import lombok.Data;

import java.util.Date;

@Data
public class KakaoPayReadyVO {
    public String tid, getNext_redirect_pc_url;

    private Date created_at;
}
