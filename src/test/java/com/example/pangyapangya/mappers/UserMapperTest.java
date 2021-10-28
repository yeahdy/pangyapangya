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
        userVO.setUserId("yejin");
        userVO.setUserPw("dpwls123^^");
        userVO.setUserName("이예진");
        userVO.setUserPhoneNum("01012345678");
        userVO.setUserZipcode("13524");
        userVO.setUserAddress("경기 성남시 분당구 대왕판교로606번길 45");
        userVO.setUserAddress_detail("(삼평동) 15층");
        userMapper.join(userVO);
    }
}
