package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.mappers.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MainDAO {
    private final MainMapper mapper;
}
