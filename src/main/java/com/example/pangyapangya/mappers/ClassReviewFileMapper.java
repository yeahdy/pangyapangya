package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassReviewFileVO;

import java.util.List;

public interface ClassReviewFileMapper {
    public void insert(ClassReviewFileVO classReviewFileVO);
//    public void delete(String uuid);
    public List<ClassReviewFileVO> findByBno(Long bno);
//    public void deleteAll(Long bno);
    public List<ClassReviewFileVO> getOldFiles();
}
