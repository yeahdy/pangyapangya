package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryReviewVO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BakeryMapper {
    //    게시글 목록
    public List<BakeryVO> getList(Criteria criteria);

    //    게시글 추가
    public void insert(BakeryVO bakeryVO);

    //    게시글 추가(PK가져오기)
    public void insertSelectKey_bno(BakeryVO bakeryVO);

    //    게시글 상세보기(특정 게시글 정보)
    public BakeryVO read(Long bno);

    //    게시글 수정
    public int update(BakeryVO bakeryVO);

    //    게시글 삭제
    public int delete(Long bno);

    //    게시글 전체 개수
    public int getTotal(Criteria criteria);

    // 해당 회원의 게시글 전체 갯수
    public int myTotal(String ceoId);

    // 사장님 회원 정보 수정
    public int ceoUpdate(CeoVO ceoVO);

    // 사장님 회원 탈퇴
    public int ceoDelete(CeoVO ceoVO);

    // 사장님이 등록한 게시글 가져오기
    public List<BakeryVO> breadList();
    //    게시글 상세정보
    public BakeryVO breadInfo(Long bno);
    //  빵 후기
    public List<BakeryReviewVO> bakeryReviewList();
    //  후기 댓글 한개
    public BakeryReviewVO reply(Long bno);
}
