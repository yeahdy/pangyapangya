package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ClassReplyMapperTest {
    private Long[] arBno = {8388648L, 8388647L, 8388646L, 8388645L, 8388644L};

    @Setter(onMethod_ = @Autowired)
    private ClassReplyMapper classReplyMapper ;

    @Test
    public void testMapper(){
        log.info(classReplyMapper.toString());
    }

    //    5칸 배열 만들기(게시글 번호 투입)
//    5개의 게시글에 2개씩 댓글 달기
    @Test
    public void testInsert(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ClassReplyVO reply = new ClassReplyVO();
            reply.setBno(arBno[i % 5]);
            reply.setContent("댓글 테스트" + i);
            reply.setUserid("replier" + i);
            classReplyMapper.insert(reply);
        });
    }

    @Test
    public void testRead(){
        log.info(classReplyMapper.read(16L).toString());
    }


    @Test
    public void testGetListWithPaging(){
        Criteria criteria = new Criteria();
        classReplyMapper.getListWithPaging(arBno[0], criteria).forEach(reply -> log.info(reply.toString()));
    }
}
