package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.mappers.BreadDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BreadDetailDAO {

    private final BreadDetailMapper mapper;

    
}
