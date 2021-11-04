package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDAO_test {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void checkIdTest(){
        if(userDAO.checkId("yejin")){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("yeahdy123");
        userVO.setUserPw("dpwls123^^");
        userVO.setUserName("박예진");
        userVO.setUserPhoneNum("01012345678");
        userVO.setUserZipcode("13524");
        userVO.setUserAddress("경기 성남시 분당구 대왕판교로606번길 45");
        userVO.setUserAddress_detail("(삼평동) 5층");
        userDAO.join(userVO);
    }

    @Test
    public void login(){
        UserVO userVO = new UserVO();
        userVO.setUserId("yejin");
        userVO.setUserPw("dpwls123^^");
        if(userDAO.login(userVO)){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }

    @Test
    public void pwFindTest(){
        if(userDAO.pwFind("yeahdy123")){
            log.info("-----------아이디 존재 O----------");
            UserVO userVO = userDAO.userInfo("yeahdy123");
            log.info( "가입한 전화번호: " + userVO.getUserPhoneNum());
        }else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    @Test
    public void userInfoTest(){
        UserVO userVO = userDAO.userInfo("yeahdy123");
        log.info(userVO.toString());
    }

    //수정 수정수정수정
}
