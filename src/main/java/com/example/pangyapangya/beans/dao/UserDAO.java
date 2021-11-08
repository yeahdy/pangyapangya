package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper mapper;

    // 아이디 중복검사
    public boolean checkId (String userId){
        return mapper.checkId(userId) == 1;
    }

    // 회원가입
    public void join(UserVO userVO){
        mapper.join(userVO);
    }

    // 회원가입 카카오
    public void joinKakao(UserVO userVO){ mapper.joinKakao(userVO); }

    // 로그인(일반회원)
    public boolean login (UserVO userVO){
        return mapper.login(userVO) == 1;
    }

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum){
        return mapper.idFind(userPhoneNum);
    }

    // 동일한 전화번호의 아이디 갯수
    public int idFindCnt (String userPhoneNum) {return mapper.idFindCnt(userPhoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFind (String userId){
        return mapper.pwFind(userId) == 1;
    }

    // 비밀번호 찾기: 아이디 + 전화번호 + 이름 같아야 인증 가능
    public boolean pwFindAuth (UserVO userVO) { return mapper.pwFindAuth(userVO) == 1; }

    // 비밀번호 변경
    public boolean pwUpdate (UserVO userVO) { return mapper.pwUpdate(userVO) == 1; }

    // 회원정보 조회(일반회원)
    public UserVO userInfo (String userId){
        return mapper.userInfo(userId);
    }
}
