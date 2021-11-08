package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.ClassReplyDAO;
import com.example.pangyapangya.beans.vo.ClassReplyPageDTO;
import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClassReplyService {
    private final ClassReplyDAO classReplyDAO;

    public int register(ClassReplyVO classReplyVO){
        log.info("register..............");
        return classReplyDAO.register(classReplyVO);
    }

    public ClassReplyVO get(Long rno){
        log.info("get..............");
        return classReplyDAO.get(rno);
    }

//    public int remove(Long rno){
//        log.info("remove..............");
//        return classReplyDAO.remove(rno);
//    }
//
//    public int modify(ClassReplyVO classReplyVO ){
//        log.info("modify..............");
//        return classReplyDAO.modify(classReplyVO);
//    }

    public ClassReplyPageDTO getList(Long bno, Criteria criteria){
        log.info("getList..............");
        return new ClassReplyPageDTO(classReplyDAO.getTotal(bno), classReplyDAO.getList(bno, criteria));
    }

}
