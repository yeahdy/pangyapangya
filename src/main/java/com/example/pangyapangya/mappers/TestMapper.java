package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.TestingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
//   게시글 가져오기
    public List<TestingVO> read();

//    게시글 추가로 가져오기
    public List<TestingVO> addData(int temp);

//    게시글 총 개수
    public int getTotal();
}
