package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CeoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CEOMapper {
    // 아이디 중복검사
    public int checkIdCEO (String ceoId);

    // 회원가입
    public void joinCEO(CeoVO ceoVO);

    // 로그인
    public int loginCEO (CeoVO ceoVO);

    // 아이디 찾기
    public List<CeoVO> idFindCEO (String ceoPhoneNum);

    //비밀번호 찾기: 아이디 유무검사
    public int pwFindCEO (String ceoId);

    // 회원정보 조회
    public CeoVO ceoInfo (String ceoId);
}
