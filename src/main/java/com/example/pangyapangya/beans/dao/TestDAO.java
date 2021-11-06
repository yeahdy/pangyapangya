package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.TestingImgVO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingReviewBoardVO;
import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.mappers.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestDAO {
    private final TestMapper mapper;

    public List<TestingVO> read(){
        return mapper.read();
    }

    public List<TestingVO> addData(int temp){
        return mapper.addData(temp);
    }

    public int getTotal(){return mapper.getTotal();}

    public TestingVO getRead(Long tno){return mapper.getRead(tno);}

    public List<TestingImgVO> getReadImgs(Long tno){return mapper.getReadImgs(tno);}

    public void addTestingRequest(TestingRequestVO testingRequestVO){mapper.addTestingRequest(testingRequestVO);}

//    모집기간 끝난 게시물
    public List<TestingVO> getEndList(){return mapper.getEndList();};

//    게시글 번호로 신청인원수 조회
    public int getRequestCnt(Long tno){return mapper.getRequestCnt(tno);};

//    전체당첨
    public boolean updateAllWinning(Long tno){return mapper.updateAllWinning(tno);};
//    랜덤 당첨
    public boolean updateWinning(Long tno, String userId){return mapper.updateWinning(tno,userId);};

//    당첨실패
    public boolean updateFail(Long tno, String userId){return mapper.updateFail(tno,userId);};

//  모집끝난 test 게시판
    public boolean endTest(Long tno){return mapper.endTest(tno);};

    public boolean resetUserApplyCnt(){return mapper.resetUserApplyCnt();};

    public List<TestingRequestVO> getRequestUser(Long tno){return mapper.getRequestUser(tno);}

//    예진님
    public List<TestingVO> mainTest(){return mapper.mainTest();}
    public List<TestingReviewBoardVO> mainReview(){return mapper.mainReview();}
}
