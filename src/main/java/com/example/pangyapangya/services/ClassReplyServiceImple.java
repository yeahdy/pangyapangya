package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.ClassReplyDAO;
import com.example.pangyapangya.beans.dao.ClassReplyFileDAO;
import com.example.pangyapangya.beans.vo.ClassReplyFileVO;
import com.example.pangyapangya.beans.vo.ClassReplyPageDTO;
import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClassReplyServiceImple implements ClassReplyService{

    private final ClassReplyDAO classReplyDAO;
    private final ClassReplyFileDAO classReplyFileDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int register(ClassReplyVO classReplyVO){
        log.info("register..............");
        return classReplyDAO.register(classReplyVO);
    }

    @Override
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
//        log.info("modify…………..");
//        return classReplyDAO.modify(classReplyVO);
//    }

    @Override
    public ClassReplyPageDTO getList(Long bno, Criteria criteria){
        log.info("getList…………..");
        return new ClassReplyPageDTO(classReplyDAO.getTotal(bno), classReplyDAO.getList(bno, criteria));
    }

    @Override
    public List<ClassReplyFileVO> getAttachList(Long rno) {
        return classReplyFileDAO.findByBno(rno);
    }


//    public List<ClassReplyFileVO> getAttachList(Long rno){
//        log.info("getList…………..");
//
//    }
}
