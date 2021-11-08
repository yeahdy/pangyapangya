package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.ClassCeoFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassCeoFileMapper {
    public void insert(ClassCeoFileVO classCeoFileVO);
    public void delete(String uuid);
    public List<ClassCeoFileVO> findByBno(Long bno);
    public void deleteAll(Long bno);
    public List<ClassCeoFileVO> getOldFiles();
}
