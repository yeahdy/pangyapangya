package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.TestingImgVO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingReviewBoardVO;
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

//    게시글 상세정보
    public TestingVO getRead(Long tno);
    
//    게시글 이미지 목록 가져오기
    public List<TestingImgVO> getReadImgs(Long tno);

//    회원 apply카운트 1로 바꿔야됨
    
//  신청하기
    public void addTestingRequest(TestingRequestVO testingRequestVO);

//    신청기간 끝난 모집글 가져오기
    public List<TestingVO> getEndList();

//    신청 갯수 가져오기
    public int getRequestCnt(Long tno);

    public boolean updateAllWinning(Long tno);
    public boolean updateWinning(Long tno, String userId);

    public boolean updateFail(Long tno, String userId);

    public boolean endTest(Long tno);

    public boolean resetUserApplyCnt();

    public List<TestingRequestVO> getRequestUser(Long tno);

    public List<TestingReviewBoardVO> getReviewBoardList();
    public List<TestingReviewBoardVO> addReviewBoard(int cnt);

    public int getReviewBoardTotal();

    public List<TestingRequestVO> getWinList();


    public String getUserNamae(String userId);
    public String getUserTel(String userId);
    public boolean requestUser(String userId);
    public String getBreadName(Long tno);
    public String getShopName(Long tno);

    public int checkRe(TestingRequestVO requestVO);

    public int checkApplyCnt(String userId);





//    예진님
//    빵 체험단 신청 게시판
    public List<TestingVO> mainTest();
//    빵 체험단 리뷰 게시판
    public List<TestingReviewBoardVO> mainReview();
}
