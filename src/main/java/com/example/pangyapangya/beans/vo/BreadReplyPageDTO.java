package com.example.pangyapangya.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class BreadReplyPageDTO {
    private int replyCnt;
    private List<BreadReviewVO> list;

    public BreadReplyPageDTO() {;}
}
