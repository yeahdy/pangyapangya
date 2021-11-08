package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ClassReplyVO {
    private Long rno;
    private Long bno;
    private String reply;
    private String replyDate;
    private String userId;
//    private List<ClassReplyFileVO> attachList;
}
