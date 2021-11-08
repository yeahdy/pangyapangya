package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClassCeoFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private Long bno;
}
