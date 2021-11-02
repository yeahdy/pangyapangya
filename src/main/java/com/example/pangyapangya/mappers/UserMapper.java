package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 아이디 중복검사
    public int checkId (String userId);

    // 회원가입(일반회원)
    public void join(UserVO userVO);

    // 회원가입(사장님)
    public void joinCEO(CeoVO ceoVO);

    // 로그인(일반회원)
    public int login (UserVO userVO);

    // 로그인(사장님)
    public int loginCEO (CeoVO ceoVO);

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum);

    // 비밀번호 찾기 : 아이디 조회
    public int pwFind (String userId);

    // 비밀번호 찾기 : 가입한 전화번호 조회
    public String pwFind_phone (String userId);

    // 상태 구분하기(일반회원)
    public int userStatus (String userId);

    // 상태 구분하기(사장님)
    public int CEOStatus (String ceoId);
}
