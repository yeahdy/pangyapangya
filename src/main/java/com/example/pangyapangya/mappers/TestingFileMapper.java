package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassCeoFileVO;
import com.example.pangyapangya.beans.vo.TestingFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestingFileMapper {
    public void insert(TestingFileVO testingFileVO);
    public void delete(String uuid);
    public List<TestingFileVO> findByBno(Long tno);
    public void deleteAll(Long tno);
    public List<TestingFileVO> getOldFiles();
}
