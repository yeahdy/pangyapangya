package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassReplyFileVO;

import java.util.List;

public interface ClassReplyFileMapper {
    public void insert(ClassReplyFileVO classReplyFileVO);

//    public void delete(String uuid);

    public List<ClassReplyFileVO> findByBno(Long rno);

//    public void deleteAll(Long bno);

    public List<ClassReplyFileVO> getOldFiles();
}
