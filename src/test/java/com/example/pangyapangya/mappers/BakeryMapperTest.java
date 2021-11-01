package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BakeryMapperTest {

    @Autowired
    private BakeryMapper bakeryMapper;

    @Test
    public void testInsert(){
        BakeryVO board = new BakeryVO();
        board.setTitle("새로 작성한 글 제목");
        board.setContent("새로 작성한 글 내용");
        board.setCeoId("wnsrbod");
        board.setCeoName("한준규");
        board.setBakeryName("뜨레쥬르");
        board.setBakeryZipcode("1234");
        board.setBakeryAddress("주소");
        board.setBakeryAddressDetail("상세주소");
        board.setBakeryPhoto("사진");
        bakeryMapper.insert(board);
    }

}
