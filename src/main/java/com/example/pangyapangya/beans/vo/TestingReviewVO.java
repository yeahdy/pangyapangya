package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingReviewVO {
    private Long rno;
    private String title;
    private String content;
    private String img;
    private String userId;
    private String reviewDate;
    private String updateDate;
    private int rating;
    private Long tno;
}
