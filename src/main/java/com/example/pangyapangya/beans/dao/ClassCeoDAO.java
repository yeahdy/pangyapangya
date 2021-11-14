package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.mappers.BakeryMapper;
import com.example.pangyapangya.mappers.ClassCeoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClassCeoDAO {
    private final ClassCeoMapper mapper;

    public void register(ClassCeoVO classCeoVO){
        mapper.insertSelectKey_bno(classCeoVO);
    }

    public ClassCeoVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(ClassCeoVO classCeoVO){ return mapper.update(classCeoVO) == 1;}

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<ClassCeoVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }
    public List<ClassCeoVO> getAllList(){return mapper.getAllList();}

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }

    public int myTotal(String ceoId){ return mapper.myTotal(ceoId); }


    // 메인페이지 글 가져오기
    public List<ClassCeoVO> classList_main() { return  mapper.classList_main(); }
}
