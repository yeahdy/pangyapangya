package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.MyPageCeoDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class MyPageCeoService {
    private final MyPageCeoDAO myPageCeoDAO;

}
