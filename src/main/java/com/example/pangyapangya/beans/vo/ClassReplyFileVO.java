package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClassReplyFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private Long rno;
}
