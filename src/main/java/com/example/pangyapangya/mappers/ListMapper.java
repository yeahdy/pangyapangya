package com.example.pangyapangya.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListMapper {
    public List<BreadListVO> getList(Criteria criteria);
}
