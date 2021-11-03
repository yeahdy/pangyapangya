package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CEOMapperTest {
    @Autowired
    private CEOMapper ceoMapper;

    @Test
    public void checkIdTest(){
        if(ceoMapper.checkIdCEO("yejinceo") == 1){
            log.info("-----------아이디 중복-----------");
        }else{
            log.info("-----------아이디 사용가능-----------");
        }
    }

    @Test
    public void joinTest(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("yejinceo");
        ceoVO.setCeoPw("dpwls123^^");
        ceoVO.setCeoName("이예진");
        ceoVO.setShopName("예진이네 빵집");
        ceoVO.setShopCallNumber("0312234812");
        ceoVO.setShopZipcode("13524");
        ceoVO.setShopAddress("경기 성남시 분당구 대왕판교로606번길 45");
        ceoVO.setShopAddressDetail("1층");
        ceoVO.setShopRegNum("1234567890");
        ceoVO.setPhoneNum("01012345678");
        ceoMapper.joinCEO(ceoVO);
    }


    @Test
    public void loginTest(){
        CeoVO ceoVO = new CeoVO();
        ceoVO.setCeoId("dpwls123");
        ceoVO.setCeoPw("dpwls000^^");
        if(ceoMapper.loginCEO(ceoVO) == 1){
            log.info("-----------로그인 완료-----------");
        }else{
            log.info("-----------로그인 실패-----------");
        }
    }

    @Test
    public void idFindTest(){
        log.info(ceoMapper.idFindCEO("01033459999").toString());
    }

    @Test
    public void pwFindTest(){
        if(ceoMapper.pwFindCEO("yejinceo") == 1){
            log.info("-----------아이디 존재 O----------");
            CeoVO ceoVO = ceoMapper.ceoInfo("yejinceo");
            log.info( "가입한 전화번호: " + ceoVO.getPhoneNum());
        } else{
            log.info("-----------아이디 존재 x----------");
        }
    }

    @Test
    public void ceoInfoTest(){
        CeoVO ceoVO = ceoMapper.ceoInfo("dpwls123");
        log.info(ceoVO.toString());
    }

}
