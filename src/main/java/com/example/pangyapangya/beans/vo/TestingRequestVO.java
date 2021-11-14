package com.example.pangyapangya.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestingRequestVO {
    Long requestNum;
    String userId;
    Long tno;
    int status;
    String winningDate;
}
