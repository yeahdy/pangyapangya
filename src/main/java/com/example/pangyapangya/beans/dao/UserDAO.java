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

    // 로그인(일반회원)
    public boolean login (UserVO userVO){
        return mapper.login(userVO) == 1;
    }

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum){
        return mapper.idFind(userPhoneNum);
    }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFind (String userId){
        return mapper.pwFind(userId) == 1;
    }

    // 회원정보 조회(일반회원)
    public UserVO userInfo (String userId){
        return mapper.userInfo(userId);
    };

    // 수정
}
