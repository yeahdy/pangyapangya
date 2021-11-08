package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.TestDAO;
import com.example.pangyapangya.beans.vo.TestingImgVO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingReviewBoardVO;
import com.example.pangyapangya.beans.vo.TestingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final TestDAO testDAO;

    public List<TestingVO> read() throws NullPointerException{return testDAO.read();}

    public List<TestingVO> addData(int temp){
        return testDAO.addData(temp);
    }

    public int getTotal(){
        return testDAO.getTotal();
    }


    public TestingVO getRead(Long tno){
        TestingVO vo = testDAO.getRead(tno);
        vo.setStartDate(vo.getStartDate().substring(0,10));
        vo.setEndDate(vo.getEndDate().substring(0,10));
        return vo;
    }

    public List<TestingImgVO> getReadImgs(Long tno){
        return testDAO.getReadImgs(tno);
    }

    public void addTestingRequest(TestingRequestVO testingRequestVO){testDAO.addTestingRequest(testingRequestVO);}

    public List<TestingReviewBoardVO> getReviewBoardList(){return testDAO.getReviewBoardList();}
    public List<TestingReviewBoardVO> addReviewBoard(int cnt){return testDAO.addReviewBoard(cnt);}

    public int getReviewBoardTotal(){return testDAO.getReviewBoardTotal();};

    public List<TestingRequestVO> getWinList(){return testDAO.getWinList();}

    public String getUserNamae(String userId){return testDAO.getUserNamae(userId);}
    public String getUserTel(String userId){return testDAO.getUserTel(userId);}
    public String getBreadName(Long tno){return testDAO.getBreadName(tno);}
    public String getShopName(Long tno){return testDAO.getShopName(tno);}
    public int checkRe(TestingRequestVO requestVO){return  testDAO.checkRe(requestVO);}
    public int checkApplyCnt(String userId){return testDAO.checkApplyCnt(userId);}
    public boolean requestUser(String userId){return testDAO.requestUser(userId);}


    //    예진님
    public List<TestingVO> mainTest(){return testDAO.mainTest();}
    public List<TestingReviewBoardVO> mainReview(){return testDAO.mainReview();}
}
