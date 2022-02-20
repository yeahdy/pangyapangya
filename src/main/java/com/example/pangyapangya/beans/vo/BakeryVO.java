package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BakeryVO {
    private Long bno;
    private String content;
    private String title;
    private String ceoId;
    private String ceoName;
    private String shopName;
    private String bakeryPhoto;
    private String regDate;
    private String breadType;
    private String breadName;
    private int breadPrice;
    private List<BakeryFileVO> attachList;
    private String keyword;
    private int replyCount;
    /*private List<BakeryFileVO> attachList;*/
}
