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
    private final ClassReplyDAO ClassReplyDAO;

    public int register(ClassReplyVO classReplyVO){
        log.info("register..............");
        return ClassReplyDAO.register(classReplyVO);
    }

    public ClassReplyVO get(Long rno){
        log.info("get..............");
        return ClassReplyDAO.get(rno);
    }

//    public int remove(Long rno){
//        log.info("remove..............");
//        return ClassReplyDAO.remove(rno);
//    }

//    public int modify(ClassReplyVO classReplyVO){
//        log.info("modify..............");
//        return ClassReplyDAO.modify(classReplyVO);
//    }

    public ClassReplyPageDTO getList(Long bno, Criteria criteria){
        log.info("getList..............");
        return new ClassReplyPageDTO(ClassReplyDAO.getTotal(bno), ClassReplyDAO.getList(bno, criteria));
    }

}
