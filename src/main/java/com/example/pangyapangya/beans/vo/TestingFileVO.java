package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class TestingFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private Long tno;
}
