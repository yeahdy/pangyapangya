package com.example.pangyapangya.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BreadListMapper {
    //  빵 이름 조회
    public void getBreadName (String breadName);

    //  빵집 이름 조회
    public void getBakeryName (String bakeyName);

    //  빵집 설명
    public void getExplain (String explain);
}
