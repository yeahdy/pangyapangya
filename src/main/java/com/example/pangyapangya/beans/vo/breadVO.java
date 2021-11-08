package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class breadVO {
    private Long bno;
    private String breadName;
    private int breadNum;
    private int breadCnt;
    private int breadPrice;
    private String breadType;
}
