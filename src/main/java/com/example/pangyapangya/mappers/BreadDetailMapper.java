package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BreadDetailMapper {
    //  빵집 이름 가져오기
    public BakeryVO call(Long bno);
}
