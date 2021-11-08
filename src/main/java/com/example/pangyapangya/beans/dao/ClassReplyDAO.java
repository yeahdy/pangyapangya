package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.mappers.ClassReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ClassReplyDAO {
    private final ClassReplyMapper classReplyMapper ;

    public int register(ClassReplyVO classReplyVO){
        log.info("register..............");
        return classReplyMapper.insert(classReplyVO);
    }

    public ClassReplyVO get(Long rno){
        log.info("get..............");
        return classReplyMapper.read(rno);
    }

    public List<ClassReplyVO> getList(Long bno, Criteria criteria){
        log.info("getList..............");
        return classReplyMapper.getListWithPaging(bno, criteria);
    }

    public int getTotal(Long bno){
        log.info("getTotal.............");
        return classReplyMapper.getTotal(bno);
    }
}
