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
        board.setShopName("뜨레쥬르");
        bakeryMapper.insert(board);
    }

}
