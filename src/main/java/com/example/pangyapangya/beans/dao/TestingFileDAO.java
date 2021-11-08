package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.TestingFileVO;
import com.example.pangyapangya.mappers.BakeryFileMapper;
import com.example.pangyapangya.mappers.TestingFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestingFileDAO {
    @Autowired
    private TestingFileMapper testingFileMapper;

    public void insert(TestingFileVO testingFileVO){
        testingFileMapper.insert(testingFileVO);
    }

    public void delete(String uuid){
        testingFileMapper.delete(uuid);
    }

    public List<TestingFileVO> findByTno(Long tno){
        return testingFileMapper.findByBno(tno);
    }

    public void deleteAll(Long tno){testingFileMapper.deleteAll(tno);}

    public List<TestingFileVO> getOldFiles() {return testingFileMapper.getOldFiles();}
}


















