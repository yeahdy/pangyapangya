package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.ClassCeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassCeoMapper {
    //    게시글 목록
    public List<ClassCeoVO> getList(Criteria criteria);
//    게시글 전체 목록
    public List<ClassCeoVO> getAllList();
    //    게시글 추가
    public void insert(ClassCeoVO classCeoVO);
    //    게시글 추가(PK가져오기)
    public void insertSelectKey_bno(ClassCeoVO classCeoVO);
    //    게시글 상세보기(특정 게시글 정보)
    public ClassCeoVO read(Long bno);
    //    게시글 수정
    public int update(ClassCeoVO classCeoVO);
    //    게시글 삭제
    public int delete(Long bno);
    //    게시글 전체 개수
    public int getTotal(Criteria criteria);
    // 해당 회원의 게시글 전체 갯수
    public int myTotal(String ceoId);


    // 메인페이지 글 가져오기
    public List<ClassCeoVO> classList_main();
}
