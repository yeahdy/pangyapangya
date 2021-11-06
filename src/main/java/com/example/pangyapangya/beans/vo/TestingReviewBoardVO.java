package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingReviewBoardVO {
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
