package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.BreadReviewVO;
import com.example.pangyapangya.mappers.BakeryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BreadDetailDAO {

    private final BakeryMapper mapper;

    public BakeryVO get(Long bno) { return mapper.breadInfo(bno); }

    public BreadReviewVO read(Long bno) { return mapper.breadReply(bno); }

}