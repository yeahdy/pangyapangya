package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

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
    public String idFind (String userPhoneNum);

    // 비밀번호 찾기
    public int pwFind (String userId);
}
