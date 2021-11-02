package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void checkIdTest(){
        if(userService.checkId("yejin33333")){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("dudgus000");
        userVO.setUserPw("dudgus123!!");
        userVO.setUserName("최영현");
        userVO.setUserPhoneNum("01099998888");
        userVO.setUserZipcode("16332");
        userVO.setUserAddress("경기 수원시 장안구 천천로22번길 34");
        userVO.setUserAddress_detail(" (정자동, 백설마을 삼환 나우빌 아파트)");
        userService.join(userVO);
    }

    @Test
    public void login(){
        UserVO userVO = new UserVO();
        userVO.setUserId("yejin");
        userVO.setUserPw("dpwls123^^");
        if(userService.login(userVO)){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }

    @Test
    public void pwFindTest(){
        if(userService.pwFind("yejin")){
            log.info("-----------아이디 존재 O----------");
            log.info( "가입한 전화번호: " + userService.pwFind_phone("yejin").toString());
        }else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    // 아이디가 존재하면 휴대폰번호 조회하기
    @Test
    public void pwFind_phoneTest(){
        log.info( "가입한 전화번호: " + userService.pwFind_phone("yejin").toString());
    }

}
