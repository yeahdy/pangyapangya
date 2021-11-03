package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.mappers.ClassCeoMapper;
import com.example.pangyapangya.mappers.TestingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestingDAO {
    private final TestingMapper mapper;

    public void register(TestingVO testingVO){
        mapper.insertSelectKey_tno(testingVO);
    }

    public TestingVO get(Long tno){
        return mapper.read(tno);
    }

    public boolean modify(TestingVO testingVO){ return mapper.update(testingVO) == 1;}

    public boolean remove(Long tno){
        return mapper.delete(tno) == 1;
    }

    public List<TestingVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }

    public int myTotal(String ceoId){ return mapper.myTotal(ceoId); }
}
