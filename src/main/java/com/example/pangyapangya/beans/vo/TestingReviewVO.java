package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingReviewVO {
    /*빵 체험단 리뷰 댓글*/
    private Long rno;
    private String title;
    private String content;
    private String img;
    private String userId;
    private int rating;
    private Long tno;
}
