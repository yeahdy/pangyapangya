package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.ClassReplyFileVO;
import com.example.pangyapangya.beans.vo.ClassReplyPageDTO;
import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassReplyService {
    public int register(ClassReplyVO classReplyVO);

    public ClassReplyVO get(Long rno);

    public ClassReplyPageDTO getList(Long bno, Criteria criteria);

    public List<ClassReplyFileVO> getAttachList(Long rno);


//    public List<ClassReplyFileVO> getAttachList(Long rno){
//        log.info("getList…………..");
//
//    }
}
