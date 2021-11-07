package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void checkIdTest(){
        if(userMapper.checkId("yejin") == 1){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("yeahdy");
        userVO.setUserPw("dpwls123^^");
        userVO.setUserName("김예진");
        userVO.setUserPhoneNum("01012345678");
        userVO.setUserZipcode("13524");
        userVO.setUserAddress("경기 성남시 분당구 대왕판교로606번길 45");
        userVO.setUserAddress_detail("(삼평동) 10층");
        userMapper.join(userVO);
    }


    @Test
    public void loginTest(){
        UserVO userVO = new UserVO();
        userVO.setUserId("yejin");
        userVO.setUserPw("dpwls123^^!!");
        if(userMapper.login(userVO) == 1){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }


    @Test
    public void idFindTest(){
        log.info(userMapper.idFind("01012345678").toString());
    }

    @Test
    public void pwFindTest(){
        if(userMapper.pwFind("yeahdy123") == 1){
            log.info("-----------아이디 존재 O----------");
            UserVO userVO = userMapper.userInfo("yeahdy123");
            log.info( "가입한 전화번호: " + userVO.getUserPhoneNum());
        } else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    @Test
    public void userInfoTest(){
        UserVO userVO = userMapper.userInfo("yeahdy123");
        log.info(userVO.toString());
    }

    //수정 수정 수정

}
