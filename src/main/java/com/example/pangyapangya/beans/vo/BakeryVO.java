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
    /*private List<BakeryFileVO> attachList;*/
}
