package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BreadReviewVO {
    private Long rno;
    private Long bno;
    private Long star;
    private String reply;
    private String userid;
    private String replydate;
}
