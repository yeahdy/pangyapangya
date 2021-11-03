package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.TestDAO;
import com.example.pangyapangya.beans.vo.TestingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final TestDAO testDAO;

    public List<TestingVO> read(){
        return testDAO.read();
    }

    public List<TestingVO> addData(int temp){
        return testDAO.addData(temp);
    }

    public int getTotal(){
        return testDAO.getTotal();
    }

    public TestingVO getRead(Long tno){
        return testDAO.getRead(tno);
    }
}
