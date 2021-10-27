package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.mappers.MyPageCeoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MyPageCeoDAO {
    private final MyPageCeoMapper mapper;
}
