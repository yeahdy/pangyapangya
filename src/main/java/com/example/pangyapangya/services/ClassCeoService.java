package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassCeoService {
    public void register(ClassCeoVO classCeoVO);
    public ClassCeoVO get(Long bno);
    public boolean modify(ClassCeoVO classCeoVO);
    public boolean remove(Long bno);
    public List<ClassCeoVO> getList(Criteria criteria);
    public int getTotal(Criteria criteria);
    public int myTotal(String ceoId);
    public CeoVO getCeo(String ceoId);
//    public List<BakeryFileVO> getAttachList(Long bno);

}
