package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.CeoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Slf4j
public class CEOServiceTest {
    @Autowired
    private CEOService ceoService;

    // 비밀번호 암호화
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Password Encode Test")
    public void passwordEncoderTest(){
        // 기존 비밀번호
        String originalPw = "123456";
        // 암호화된 비밀번호를 반환
        String encodePassword = passwordEncoder.encode(originalPw);

        // matches()? 내부에서 평문 비밀번호와 암호화된 비밀번호가 서로 대칭되는지 true, false로 반환해줌
        if(passwordEncoder.matches(originalPw, encodePassword)){
            log.info("일치 합니다");
            log.info("암호화된 코드: " + encodePassword);
        }else{
            log.info("불일치 합니다");
        }
    }


    @Test
    public void checkIdTest(){
        if(ceoService.checkIdCEO("yejin")){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("alsrud123");
        ceoVO.setCeoPw("alsrud000!");
        ceoVO.setCeoName("주민경");
        ceoVO.setPhoneNum("01033445577");
        ceoVO.setShopRegNum("1234567890");
        ceoVO.setShopName("민경이네 빵집");
        ceoVO.setShopZipcode("13524");
        ceoVO.setShopAddress("경기 성남시 분당구 대왕판교로606번길 45");
        ceoVO.setShopAddressDetail("삼평동 13층");
        ceoVO.setShopCallNumber("0312234812");
        ceoService.joinCEO(ceoVO);
    }

    @Test
    public void login(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("yedeec2o");
        ceoVO.setCeoPw("dpwls123!");
        if(ceoService.loginCEO(ceoVO)){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }

    @Test
    public void pwFindTest(){
        if(ceoService.pwFindCEO("yedeec2o")){
            log.info("-----------아이디 존재 O----------");
            CeoVO ceoVO = ceoService.ceoInfo("yedeec2o");
            log.info( "가입한 전화번호: " + ceoVO.getPhoneNum());
        }else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    @Test
    public void ceoInfoTest(){
        CeoVO ceoVO = ceoService.ceoInfo("yedeec2o");
        log.info(ceoVO.toString());
    }

}
