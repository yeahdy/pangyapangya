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

    private PasswordEncoder passwordEncoder;

    // 아이디 중복검사
    public boolean checkIdCEO (String ceoId){
        return ceoDAO.checkIdCEO(ceoId);
    }

    // 회원가입
    public void joinCEO (CeoVO ceoVO){ ceoDAO.joinCEO(ceoVO); }

    // 로그인
    public boolean loginCEO (CeoVO ceoVO){ return ceoDAO.loginCEO(ceoVO); }

    // 아이디찾기
    public List<CeoVO> idFindCEO (String phoneNum){ return ceoDAO.idFindCEO(phoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFindCEO (String ceoId){ return ceoDAO.pwFindCEO(ceoId); }

    // 회원정보 조회
    public CeoVO ceoInfo (String ceoId){ return ceoDAO.ceoInfo(ceoId); }
}

