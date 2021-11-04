//package com.example.pangyapangya.services;
//
//import com.example.pangyapangya.beans.vo.UserVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@SpringBootTest
//@Slf4j
//public class UserServiceTest {
//    @Autowired
//    private UserService userService;
//
//    // 비밀번호 암호화
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    @DisplayName("Password Encode Test")
//    public void passwordEncoderTest(){
//        // 기존 비밀번호
//        String originalPw = "123456";
//        // 암호화된 비밀번호를 반환
//        String encodePassword = passwordEncoder.encode(originalPw);
//
//        // matches()? 내부에서 평문 비밀번호와 암호화된 비밀번호가 서로 대칭되는지 true, false로 반환해줌
//        if(passwordEncoder.matches(originalPw, encodePassword)){
//            log.info("일치 합니다");
//            log.info("암호화된 코드: " + encodePassword);
//        }else{
//            log.info("불일치 합니다");
//        }
//    }
//
//    @Test
//    @DisplayName("joinEncoderTest")
//    public void joinEncoderTest(){
//        // 기존 비밀번호
//        String originalPw = "12345";
//        // 암호화된 비밀번호를 반환
//        String encodePassword = passwordEncoder.encode(originalPw);
//        UserVO userVO = new UserVO();
//        userVO.setUserId("nang000");
//        userVO.setUserPw(encodePassword);
//        userVO.setUserName("권나영");
//        userVO.setUserPhoneNum("01099991212");
//        userVO.setUserZipcode("16332");
//        userVO.setUserAddress("경기 수원시 장안구 천천로22번길 34");
//        userVO.setUserAddress_detail(" (정자동, 백설마을 삼환 나우빌 아파트)");
//        userService.join(userVO);
//        log.info("암호화된 비밀번호로 DB저장 성공");
//        log.info(userVO.toString());
//    }
//
//    @Test
//    public void checkIdTest(){
//        if(userService.checkId("yejin33333")){
//            log.info("-----------아이디 중복-----------");
//        }else{
//            log.info("-----------아이디 사용가능-----------");
//        }
//    }
//
//    @Test
//    public void joinTest(){
//        UserVO userVO = new UserVO();
//        userVO.setUserId("dudgus000");
//        userVO.setUserPw("dudgus123!!");
//        userVO.setUserName("최영현");
//        userVO.setUserPhoneNum("01099998888");
//        userVO.setUserZipcode("16332");
//        userVO.setUserAddress("경기 수원시 장안구 천천로22번길 34");
//        userVO.setUserAddress_detail(" (정자동, 백설마을 삼환 나우빌 아파트)");
//        userService.join(userVO);
//    }
//
//    @Test
//    public void login(){
//        UserVO userVO = new UserVO();
//        userVO.setUserId("yejin");
//        userVO.setUserPw("dpwls123^^");
//        if(userService.login(userVO)){
//            log.info("-----------로그인 완료-----------");
//        }else{
//            log.info("-----------로그인 실패-----------");
//        }
//    }
//
//    @Test
//    public void pwFindTest(){
//        if(userService.pwFind("yejin")){
//            log.info("-----------아이디 존재 O----------");
//            UserVO userVO = userService.userInfo("yeahdy123");
//            log.info( "가입한 전화번호: " + userVO.getUserPhoneNum());
//        }else{
//            log.info("-----------아이디 존재 x----------");
//        }
//    }
//
//    @Test
//    public void userInfoTest(){
//        UserVO userVO = userService.userInfo("yeahdy123");
//        log.info(userVO.toString());
//    }
//
//    //수정수정수정
//}
