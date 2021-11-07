package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.ClassCeoFileVO;
import com.example.pangyapangya.mappers.BakeryFileMapper;
import com.example.pangyapangya.mappers.ClassCeoFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassCeoFileDAO {
    @Autowired
    private ClassCeoFileMapper classCeoFileMapper;

    public void insert(ClassCeoFileVO classCeoFileVO){
        classCeoFileMapper.insert(classCeoFileVO);
    }

    public void delete(String uuid){
        classCeoFileMapper.delete(uuid);
    }

    public List<ClassCeoFileVO> findByBno(Long bno){
        return classCeoFileMapper.findByBno(bno);
    }

    public void deleteAll(Long bno){classCeoFileMapper.deleteAll(bno);}

    public List<ClassCeoFileVO> getOldFiles() {return classCeoFileMapper.getOldFiles();}
}


















