package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.BakeryFileVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.CeoVO;
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
    public int myTotal(String ceoId);
    public CeoVO getCeo(String ceoId);
    public boolean ceoUpdate(CeoVO ceoVO);
    public boolean ceoDelete(CeoVO ceoVO);
    public List<BakeryVO> breadList(String keyword);
//    public List<BakeryFileVO> getAttachList(Long bno);

    public List<BakeryVO> breadListCeo(BakeryVO bakeryVO);
    public List<BakeryFileVO> getAttachList(Long bno);

    // 메인페이지 글가져오기
    public List<BakeryVO> breadList_main();

}
