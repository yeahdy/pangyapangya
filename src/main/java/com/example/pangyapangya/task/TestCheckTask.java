package com.example.pangyapangya.task;

import com.example.pangyapangya.beans.dao.TestDAO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.beans.vo.WinDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class TestCheckTask {
    @Autowired
    private TestDAO testDAO;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkTesting() {
        List<TestingVO> endList = testDAO.getEndList();

        for (TestingVO testingVO : endList) {
            Long tno = testingVO.getTno();
            int peopleCnt = testingVO.getPeople();
            int requestCnt = testDAO.getRequestCnt(tno);

            if (peopleCnt > requestCnt){
                testDAO.updateAllWinning(tno);
            }else {
                List<TestingRequestVO> requestList = testDAO.getRequestUser(tno);
                TestingRequestVO item = null;

                Collections.shuffle(requestList);

                for (int i = 0; i < requestList.size(); i++) {
                    item = requestList.get(i);

                    if(i<peopleCnt){
                        testDAO.updateWinning(tno, item.getUserId());
                    }else {
                        testDAO.updateFail(tno, item.getUserId());
                    }
                }
            }
            testDAO.endTest(tno);
        }
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void sendMessage(){
        List<TestingRequestVO> winList= testDAO.getWinList();
        WinDTO dto = new WinDTO();

        for (TestingRequestVO vo : winList) {
            dto.setBreadName(testDAO.getBreadName(vo.getTno()));
            dto.setShopName(testDAO.getShopName(vo.getTno()));
            dto.setPhoneNumber(testDAO.getUserTel(vo.getUserId()));
            dto.setUserName(testDAO.getUserNamae(vo.getUserId()));

            testDAO.sendWinMessage(dto);

            dto = new WinDTO();
        }

    }


//  매일 회원 신청횟수 초기화
    @Scheduled(cron = "0 0 0 * * *")
    public void resetApplyCnt(){
        testDAO.resetUserApplyCnt();
    }
}
