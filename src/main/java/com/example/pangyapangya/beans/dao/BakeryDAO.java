package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.mappers.BakeryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BakeryDAO {
    private final BakeryMapper mapper;

    public void register(BakeryVO bakeryVO){
        mapper.insertSelectKey_bno(bakeryVO);
    }

    public BakeryVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BakeryVO bakeryVO){ return mapper.update(bakeryVO) == 1;}

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<BakeryVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }

    public int myTotal(String ceoId){ return mapper.myTotal(ceoId); }

    public boolean ceoUpdate(CeoVO ceoVO){ return mapper.ceoUpdate(ceoVO) == 1; }

    public boolean ceoDelete(CeoVO ceoVO){ return mapper.ceoDelete(ceoVO) == 1;}

    public List<BakeryVO> breadListCeo(BakeryVO bakeryVO){ return mapper.breadListCeo(bakeryVO);}
    public List<BakeryVO> breadList(String keyword){ return mapper.breadList(keyword);}

    // 메인페이지 글가져오기
    public List<BakeryVO> breadList_main() { return mapper.breadList_main(); }
}
