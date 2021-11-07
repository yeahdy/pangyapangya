package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.*;
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
    public List<TestingFileVO> getAttachList(Long tno);

}
