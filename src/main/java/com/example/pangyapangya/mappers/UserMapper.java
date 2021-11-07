package com.example.pangyapangya.mappers;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 아이디 중복검사
    public int checkId (String userId);

    // 회원가입(일반회원)
    public void join(UserVO userVO);

    // 회원가입(일반회원)
    public void joinKakao(UserVO userVO);

    // 로그인(일반회원)
    public int login (UserVO userVO);

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum);

    // 동일한 전화번호의 아이디 갯수
    public int idFindCnt (String userPhoneNum);

    // 비밀번호 찾기 : 아이디 조회
    public int pwFind (String userId);

    // 비밀번호 찾기: 아이디 + 전화번호 + 이름 같아야 인증 가능
    public int pwFindAuth (UserVO userVO);

    // 비밀번호 변경
    public int pwUpdate (UserVO userVO);

    // 회원정보 조회(일반회원)
    public UserVO userInfo (String userId);
}
