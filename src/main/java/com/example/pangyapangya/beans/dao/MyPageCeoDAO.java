package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.mappers.MyPageCeoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyPageCeoDAO {
    private final MyPageCeoMapper mapper;

    public void register(BakeryVO board){
        mapper.insertSelectKey_bno(board);
    }

    public BakeryVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BakeryVO board){
        return mapper.update(board) == 1;
    }

    public boolean remove(Long bno){
        return mapper.delete(bno) == 1;
    }

    public List<BakeryVO> getList(Criteria criteria){
        return mapper.getList(criteria);
    }

    public int getTotal(Criteria criteria){ return mapper.getTotal(criteria); }
}
