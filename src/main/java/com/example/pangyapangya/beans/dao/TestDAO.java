package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.*;
import com.example.pangyapangya.mappers.TestMapper;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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

    public List<TestingReviewBoardVO> getReviewBoardList(){return mapper.getReviewBoardList();}
    public List<TestingReviewBoardVO> addReviewBoard(int cnt){return mapper.addReviewBoard(cnt);}

    public int getReviewBoardTotal(){return mapper.getReviewBoardTotal();};

    public List<TestingRequestVO> getWinList(){return mapper.getWinList();}

    public String getUserNamae(String userId){return mapper.getUserNamae(userId);}
    public String getUserTel(String userId){return mapper.getUserTel(userId);}
    public String getBreadName(Long tno){return mapper.getBreadName(tno);}
    public String getShopName(Long tno){return mapper.getShopName(tno);}
    public int checkRe(TestingRequestVO requestVO){return  mapper.checkRe(requestVO);}
    public int checkApplyCnt(String userId){return mapper.checkApplyCnt(userId);}
    public boolean requestUser(String userId){return mapper.requestUser(userId);}




    public void sendWinMessage(WinDTO win) {
        String api_key = "NCSQNB02FGNIJWVJ";
        String api_secret = "XKUECSFOHIBWYHNANPTKSRVMTZQLEIPP";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", win.getPhoneNumber());    // 수신전화번호
        params.put("from", "01085362558");    // 발신전화번호
        params.put("type", "lms");
        params.put("text", "[빵야빵야(屋)]\n축하드립니다 "+win.getUserName()+"님!"+"\n빵야빵야(屋) "+ win.getShopName()+" "+ win.getBreadName() + "\n빵 체험단에 당첨되셨습니다.\n자세한 내용은 빵야빵야(屋) 홈페이지를 참고해 주세요.\nwww.PangyaPangya.com");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }




//    예진님
    public List<TestingVO> mainTest(){return mapper.mainTest();}
    public List<TestingReviewBoardVO> mainReview(){return mapper.mainReview();}
}
