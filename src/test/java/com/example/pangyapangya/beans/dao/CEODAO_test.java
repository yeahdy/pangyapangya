package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.CeoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CEODAO_test {
/*
    @Autowired
    private CEODAO ceoDAO;

    @Test
    public void checkIdTest(){
        if(ceoDAO.checkIdCEO("yejinceo")){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("yedeec2o");
        ceoVO.setCeoPw("dpwls123!");
        ceoVO.setCeoName("김예진");
        ceoVO.setPhoneNum("01033445566");
        ceoVO.setShopRegNum("1234567890");
        ceoVO.setShopName("김이네 빵집");
        ceoVO.setShopZipcode("13524");
        ceoVO.setShopAddress("경기 성남시 분당구 대왕판교로606번길 45");
        ceoVO.setShopAddressDetail("(삼평동) 5층");
        ceoVO.setShopCallNumber("0312234812");
        ceoDAO.joinCEO(ceoVO);
    }


    @Test
    public void loginTest(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("yedeec2o");
        ceoVO.setCeoPw("dpwls123^^!!");
        if(ceoDAO.loginCEO(ceoVO)){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }

    @Test
    public void idFindTest(){
        log.info(ceoDAO.idFindCEO("01012345678").toString());
    }

    @Test
    public void pwFindTest(){
        if(ceoDAO.pwFindCEO("yejinceo")){
            log.info("-----------아이디 존재 O----------");
            CeoVO ceoVO = ceoDAO.ceoInfo("yejinceo");
            log.info( "가입한 전화번호: " + ceoVO.getPhoneNum());
        } else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    @Test
    public void ceoInfoTest(){
        CeoVO ceoVO = ceoDAO.ceoInfo("yejinceo");
        log.info(ceoVO.toString());
    }
*/

}
