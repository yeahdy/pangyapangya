package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryReviewVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.mappers.BakeryMapper;
import com.example.pangyapangya.mappers.BreadDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BreadDetailDAO {

    private final BakeryMapper mapper;

    public BakeryVO get(Long bno) { return mapper.breadInfo(bno); }

    public BakeryReviewVO load(Long bno) { return mapper.reply(bno);}

    public List<BakeryReviewVO> replyList(){ return mapper.bakeryReviewList(); }
}