package com.example.pangyapangya.beans.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@Slf4j
public class TestDaoTest {
    @Autowired
    private TestDAO testDao;

    @Test
    public void test(){
//        testDao.getEndList();
//        log.info("--------------------------------------------------");
//        log.info("결과 : " + testDao.getRequestUser(1L));
//        log.info("--------------------------------------------------");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Collections.shuffle(list);

        log.info("list : "+list);
    }
}
