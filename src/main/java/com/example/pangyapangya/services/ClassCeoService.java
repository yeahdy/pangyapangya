package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassCeoService {
    public void register(ClassCeoVO classCeoVO);
    public ClassCeoVO get(Long bno);
    public boolean modify(ClassCeoVO classCeoVO);
    public boolean remove(Long bno);
    public List<ClassCeoVO> getList(Criteria criteria);
    public List<ClassCeoVO> getAllList();
    public int getTotal(Criteria criteria);
    public int myTotal(String ceoId);
    public CeoVO getCeo(String ceoId);
    public List<ClassCeoFileVO> getAttachList(Long bno);


    // 메인페이지 글 가져오기
    public List<ClassCeoVO> classList_main();

}
