package com.example.pangyapangya.beans.dao;

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
public class ClassReplyDAO_test {
    private Long[] arBno = {1L, 2L, 3L, 4L, 5L};

    @Setter(onMethod_ = @Autowired)
    private ClassReplyDAO classReplyDAO;

    @Test
    public void testDAO(){
        log.info(classReplyDAO.toString());
    }

    //    5칸 배열 만들기(게시글 번호 투입)
//    5개의 게시글에 2개씩 댓글 달기
    @Test
    public void testInsert(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            ClassReplyVO reply = new ClassReplyVO();
            reply.setBno(arBno[i % 5]);
            reply.setReply("댓글 테스트" + i);
            classReplyDAO.register(reply);
        });
    }

    @Test
    public void testRead(){
        log.info(classReplyDAO.get(1L).toString());
    }

//    @Test
//    public void testDelete(){
//        log.info("DELETE COUNT : " + classReplyDAO.remove(15L));
//    }
//
//    @Test
//    public void testUpdate(){
//        ReplyVO replyVO = classReplyDAO.get(16L);
//        replyVO.setReply("UPDATE TEST");
//        log.info("UPDATE COUNT : " + classReplyDAO.modify(replyVO));
//    }

    @Test
    public void testGetListWithPaging(){
        Criteria criteria = new Criteria();
        classReplyDAO.getList(arBno[0], criteria).forEach(reply -> log.info(reply.toString()));
    }
}
