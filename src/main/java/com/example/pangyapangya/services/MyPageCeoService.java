package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyPageCeoService {
    public void register(BakeryVO bakery);
    public BakeryVO get(Long bno);
    public boolean modify(BakeryVO bakery);
    public boolean remove(Long bno);
    public List<BakeryVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
//    public List<AttachFileVO> getAttachList(Long bno);

}
