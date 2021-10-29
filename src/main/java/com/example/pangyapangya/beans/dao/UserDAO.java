package com.example.pangyapangya.beans.dao;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper mapper;

    // 아이디 중복검사
    public boolean checkId (String userId){
        return mapper.checkId(userId) == 1;
    }

    // 회원가입(일반회원)
    public void join(UserVO userVO){
        mapper.join(userVO);
    }

    // 회원가입(사장님)
    public void joinCEO(CeoVO ceoVO){
        mapper.joinCEO(ceoVO);
    }

    // 로그인(일반회원)
    public boolean login (UserVO userVO){
        return mapper.login(userVO) == 1;
    }

    // 로그인(사장님)
    public boolean loginCEO (CeoVO ceoVO){
        return mapper.loginCEO(ceoVO) == 1;
    }

    // 아이디찾기
    public String idFind (String userPhoneNum){
        return mapper.idFind(userPhoneNum);
    }

    // 비밀번호 찾기
    public boolean pwFind (String userId){
        return mapper.pwFind(userId) == 1;
    }
}
