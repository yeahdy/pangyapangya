package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private int people;
    private String description;
    private String regDate;
    private String shopName;
    private int status;
    private String testingPhoto;
    private List<TestingFileVO> attachList;

}