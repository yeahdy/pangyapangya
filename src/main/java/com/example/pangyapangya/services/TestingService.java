package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.TestingVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestingService {
    public void register(TestingVO testingVO);
    public TestingVO get(Long tno);
    public boolean modify(TestingVO testingVO);
    public boolean remove(Long tno);
    public List<TestingVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
    public int myTotal(String ceoId);
    public CeoVO getCeo(String ceoId);
//    public List<BakeryFileVO> getAttachList(Long bno);

}