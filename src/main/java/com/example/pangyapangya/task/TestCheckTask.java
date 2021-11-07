package com.example.pangyapangya.task;

import com.example.pangyapangya.beans.dao.ClassReviewFileDAO;
import com.example.pangyapangya.beans.dao.TestDAO;
import com.example.pangyapangya.beans.dao.TestingDAO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class TestCheckTask {
    @Autowired
    private TestDAO testDAO;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkTesting() {
        List<TestingVO> endList = testDAO.getEndList();
        Random r = new Random();

        for (TestingVO testingVO : endList) {
            Long tno = testingVO.getTno();
            int peopleCnt = testingVO.getPeople();
            int requestCnt = testDAO.getRequestCnt(tno);

            if (peopleCnt > requestCnt){
                testDAO.updateAllWinning(tno);
            }else {
                List<TestingRequestVO> requestList = testDAO.getRequestUser(tno);
                TestingRequestVO item = null;
                int temp = 0;

                Collections.shuffle(requestList);

                for (int i = 0; i < peopleCnt; i++) {
                    item = requestList.get(i);
                    temp++;

                    testDAO.updateWinning(tno, item.getUserID());
                }
                for (int i = 0; i < requestCnt-peopleCnt; i++) {
                    item = requestList.get(temp);
                    temp++;

                    testDAO.updateFail(tno, item.getUserID());
                }
            }
            testDAO.endTest(tno);
        }
    }

//  매일 회원 신청횟수 초기화
    @Scheduled(cron = "0 0 0 * * *")
    public void resetApplyCnt(){
        testDAO.resetUserApplyCnt();
    }
}
