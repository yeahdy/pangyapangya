package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.UserDAO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
//0
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    // 아이디 중복확인
    public boolean checkId(String userId){
        return userDAO.checkId(userId);
    }

    // 회원가입(일반회원)
    public void join(UserVO userVO){
        userDAO.join(userVO);
    }

    // 회원가입(사장님)
    public void joinCEO(CeoVO ceoVO){
        userDAO.joinCEO(ceoVO);
    }

    // 로그인(일반회원)
    public boolean login (UserVO userVO){
        return userDAO.login(userVO);
    }

    // 로그인(사장님)
    public boolean loginCEO (CeoVO ceoVO){
        return userDAO.loginCEO(ceoVO);
    }

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum){
        return userDAO.idFind(userPhoneNum);
    }

    // 비밀번호 찾기 : 아이디 조회
    public boolean pwFind (String userId){
        return userDAO.pwFind(userId);
    }

    // 비밀번호 찾기 : 가입한 전화번호 조회
    public String pwFind_phone (String userId) {return userDAO.pwFind_phone(userId); }


    // 인증번호(전화번호, 인증번호)
    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {

        String api_key = "NCSQNB02FGNIJWVJ";
        String api_secret = "XKUECSFOHIBWYHNANPTKSRVMTZQLEIPP";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "01085362558");    // 발신전화번호
        params.put("type", "SMS");
        params.put("text", "빵야빵야(屋) 인증번호 " + "["+cerNum+"]" + "를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

    }
}

