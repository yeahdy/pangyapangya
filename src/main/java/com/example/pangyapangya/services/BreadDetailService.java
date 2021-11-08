package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.BreadReviewVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreadDetailService {
    public BakeryVO getInfo(Long bno);
    /*public BreadReviewVO getReply(Long bno);*/
    public List<BreadReviewVO> getListWithPaging(Long bno, Criteria criteria);

}
