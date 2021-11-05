package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.mappers.BakeryMapper;
import com.example.pangyapangya.mappers.BreadDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BreadDetailDAO {

    private final BakeryMapper mapper;

    public BakeryVO get(Long bno) { return mapper.breadInfo(bno); }

}
