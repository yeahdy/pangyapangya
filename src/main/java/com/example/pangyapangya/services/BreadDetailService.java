package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.BreadDetailDAO;
import com.example.pangyapangya.beans.vo.BakeryReviewVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreadDetailService {

    private final BreadDetailDAO breadDetailDAO;

    public BakeryVO getInfo(Long bno){return breadDetailDAO.get(bno);}

    public BakeryReviewVO getRep(Long bno){ return breadDetailDAO.load(bno); }

}