package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.mappers.CEOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CEODAO {
    private final CEOMapper mapper;

    // 아이디 중복검사
    public boolean checkIdCEO (String ceoId){
        return mapper.checkIdCEO(ceoId) == 1;
    }

    // 회원가입
    public void joinCEO (CeoVO ceoVO){ mapper.joinCEO(ceoVO); }

    // 로그인
    public boolean loginCEO (CeoVO ceoVO){ return mapper.loginCEO(ceoVO) == 1; }

    // 아이디찾기
    public List<CeoVO> idFindCEO (String phoneNum){ return mapper.idFindCEO(phoneNum); }

    // 아이디 찾기 갯수
    public int idFindCntCEO (String phoneNum){ return mapper.idFindCntCEO(phoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFindCEO (String ceoId){ return mapper.pwFindCEO(ceoId) == 1; }

    // 비밀번호 찾기: 아이디 + 전화번호 + 이름 같아야 인증 가능
    public boolean pwFindAuthCEO (CeoVO ceoVO) {return mapper.pwFindAuthCEO(ceoVO) == 1; }

    // 비밀번호 변경
    public boolean pwUpdateCEO (CeoVO ceoVO) {return mapper.pwUpdateCEO(ceoVO) == 1;}

    // 회원정보 조회
    public CeoVO ceoInfo (String ceoId){ return mapper.ceoInfo(ceoId); }
}
