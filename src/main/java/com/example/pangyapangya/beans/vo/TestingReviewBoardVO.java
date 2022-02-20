package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingReviewBoardVO {
    /*빵체험단 리뷰게시판*/
    Long tno;
    String ceoId;
    String title;
    String breadType;
    String BreadName;
    String description;
    String testingPhoto;
    String shopName;
    int reviewCnt;
}
