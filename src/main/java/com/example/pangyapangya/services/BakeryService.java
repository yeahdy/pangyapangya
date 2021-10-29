package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BakeryService {
    public void register(BakeryVO bakeryVO);
    public BakeryVO get(Long bno);
    public boolean modify(BakeryVO bakeryVO);
    public boolean remove(Long bno);
    public List<BakeryVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
    public List<BakeryFileVO> getAttachList(Long bno);

}