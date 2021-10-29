package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.mappers.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestDAO {
    private final TestMapper mapper;
}
