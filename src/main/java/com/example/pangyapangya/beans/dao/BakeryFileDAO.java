package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.mappers.BakeryFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BakeryFileDAO {
    @Autowired
    private BakeryFileMapper bakeryFileMapper;

    public void insert(BakeryFileVO bakeryFileVO){
        bakeryFileMapper.insert(bakeryFileVO);
    }

    public void delete(String uuid){
        bakeryFileMapper.delete(uuid);
    }

    public List<BakeryFileVO> findByBno(Long bno){
        return bakeryFileMapper.findByBno(bno);
    }

    public void deleteAll(Long bno){bakeryFileMapper.deleteAll(bno);}

    public List<BakeryFileVO> getOldFiles() {return bakeryFileMapper.getOldFiles();}
}


















