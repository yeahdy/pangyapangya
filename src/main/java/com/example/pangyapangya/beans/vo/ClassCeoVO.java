package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ClassCeoVO {
    private Long bno;
    private String title;
    private String ceoId;
    private String ceoName;
    private String classPhoto;
    private int classPrice;
    private String regDate;
    private String endDate;
    private String classDate;
    private int recruitment;
    private String description;
    private String breadType;
    private String breadName;
    private String shopName;
    private int reviewCnt;
    private List<ClassCeoFileVO> attachList;
}
