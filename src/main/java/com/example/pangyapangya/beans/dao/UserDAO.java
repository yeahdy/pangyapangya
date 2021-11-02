package com.example.pangyapangya.beans.dao;

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
    public List<UserVO> idFind (String userPhoneNum){
        return mapper.idFind(userPhoneNum);
    }

    // 동일한 전화번호의 아이디 갯수
    public int idFindCnt (String userPhoneNum) {return mapper.idFindCnt(userPhoneNum); }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFind (String userId){
        return mapper.pwFind(userId) == 1;
    }

    // 비밀번호 찾기 : 가입한 전화번호 조회
    public String pwFind_phone (String userId) {return mapper.pwFind_phone(userId); }
}
