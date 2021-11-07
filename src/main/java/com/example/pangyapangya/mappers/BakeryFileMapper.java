package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.AttachFileVO;
import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BakeryFileMapper {
    public void insert(BakeryFileVO bakeryFileVO);
    public void delete(String uuid);
    public List<BakeryFileVO> findByBno(Long bno);
    public void deleteAll(Long bno);
    public List<BakeryFileVO> getOldFiles();
}
