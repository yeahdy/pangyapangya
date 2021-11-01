package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.CEODAO;
import com.example.pangyapangya.beans.vo.CeoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CEOService {
    private final CEODAO ceoDAO;
    private final PasswordEncoder passwordEncoder;

    // 아이디 중복검사
    public boolean checkIdCEO (String ceoId){
        return ceoDAO.checkIdCEO(ceoId);
    }

    // 회원가입 + 비밀번호 암호화
    public void joinCEO (CeoVO ceoVO){
        if(ceoVO != null){
            // 비밀번호 암호화
            System.out.println("사용자 비밀번호: " + ceoVO.getCeoPw());
            String encodedPw = passwordEncoder.encode(ceoVO.getCeoPw());
            System.out.println("암호화된 비밀번호: " + encodedPw);

            // 암호화된 비밀번호로 저장
            ceoVO.setCeoPw(encodedPw);
            ceoDAO.joinCEO(ceoVO);
        }
    }

    // 로그인
    public boolean loginCEO (CeoVO ceoVO){ return ceoDAO.loginCEO(ceoVO); }

    // 아이디찾기
    public List<CeoVO> idFindCEO (String phoneNum){ return ceoDAO.idFindCEO(phoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFindCEO (String ceoId){ return ceoDAO.pwFindCEO(ceoId); }

    // 회원정보 조회
    public CeoVO ceoInfo (String ceoId){ return ceoDAO.ceoInfo(ceoId); }
}

