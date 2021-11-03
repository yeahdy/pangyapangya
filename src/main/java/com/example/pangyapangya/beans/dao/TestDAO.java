package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.mappers.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestDAO {
    private final TestMapper mapper;

    public List<TestingVO> read(){
        return mapper.read();
    }

    public List<TestingVO> addData(int temp){
        return mapper.addData(temp);
    }

    public int getTotal(){
        return mapper.getTotal();
    }
}
