package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.TestingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestingMapper {
    //    게시글 목록
    public List<TestingVO> getList(Criteria criteria);
    //    게시글 추가
    public void insert(TestingVO testingVO);
    //    게시글 추가(PK가져오기)
    public void insertSelectKey_tno(TestingVO testingVO);
    //    게시글 상세보기(특정 게시글 정보)
    public TestingVO read(Long tno);
    //    게시글 수정
    public int update(TestingVO testingVO);
    //    게시글 삭제
    public int delete(Long tno);
    //    게시글 전체 개수
    public int getTotal(Criteria criteria);
    // 해당 회원의 게시글 전체 갯수
    public int myTotal(String ceoId);
}
