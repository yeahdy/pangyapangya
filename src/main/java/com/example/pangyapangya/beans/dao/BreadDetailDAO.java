package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.BreadReviewVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.mappers.BakeryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BreadDetailDAO {

    private final BakeryMapper mapper;

    public BakeryVO get(Long bno) { return mapper.breadInfo(bno); }

    public BreadReviewVO read(Long bno) { return mapper.breadReply(bno); }

    public List<BreadReviewVO> getListWithPaging(Long bno, Criteria criteria){
        return mapper.getListWithPaging(bno, criteria);
    }

}