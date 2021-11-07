package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.ClassReplyFileVO;
import com.example.pangyapangya.mappers.ClassReplyFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassReplyFileDAO {
    @Autowired
    private ClassReplyFileMapper classReplyFileMapper;

    public void insert(ClassReplyFileVO classReplyFileVO){
        classReplyFileMapper.insert(classReplyFileVO);
    }

//    public void delete(String uuid){
//        classReplyFileMapper.delete(uuid);
//    }

    public List<ClassReplyFileVO> findByBno(Long rno){
        return classReplyFileMapper.findByBno(rno);
    }

//    public void deleteAll(Long bno){classReplyFileMapper.deleteAll(bno);}

    public List<ClassReplyFileVO> getOldFiles() {return classReplyFileMapper.getOldFiles();}
}
