package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.dao.ClassReplyDAO;
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
    private Long[] arBno = {1L, 2L, 3L, 4L, 5L};

    @Setter(onMethod_ = @Autowired)
    private ClassReplyMapper classReplyMapper;

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
            reply.setReply("댓글 테스트" + i);
            classReplyMapper.insert(reply);
        });
    }

    @Test
    public void testRead(){
        log.info(classReplyMapper.read(11L).toString());
    }

//    @Test
//    public void testDelete(){
//        log.info("DELETE COUNT : " + classReplyMapper.delete(15L));
//    }
//
//    @Test
//    public void testUpdate(){
//        ClassReplyVO classReplyVO = classReplyMapper.read(16L);
//        classReplyVO.setReply("UPDATE TEST");
//        log.info("UPDATE COUNT : " + classReplyMapper.update(classReplyVO));
//    }

    @Test
    public void testGetListWithPaging(){
        Criteria criteria = new Criteria();
        classReplyMapper.getListWithPaging(arBno[0], criteria).forEach(reply -> log.info(reply.toString()));
    }
}
