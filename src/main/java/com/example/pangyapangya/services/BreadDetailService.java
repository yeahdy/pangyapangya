package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.BreadDetailDAO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BreadDetailService {

    private final BreadDetailDAO breadDetailDAO;

    @Override
    public BakeryVO get(Long bno) { return BreadDetailDAO.get(bno); }
}
