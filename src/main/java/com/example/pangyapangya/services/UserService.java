package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.UserDAO;
import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    // 아이디 중복확인
    public boolean checkId(String userId){
        return userDAO.checkId(userId);
    }

    // 회원가입 + 비밀번호 암호화
    public void join(UserVO userVO){
        if(userVO != null){
            // 비밀번호 암호화
            String encodedPw = passwordEncoder.encode(userVO.getUserPw());
            System.out.println("암호화된 비밀번호: " + encodedPw);

            // 암호화된 비밀번호로 저장
            userVO.setUserPw(encodedPw);
            userDAO.join(userVO);
        }
    }

    // 카카오 회원가입
    public void joinKakao(UserVO userVO){
        userDAO.joinKakao(userVO);
    }

    // 로그인 + 비밀번호 암호화 비교하기
    @Transactional(rollbackFor = Exception.class)
    public boolean login (UserVO userVO){
        // 사용자가 입력한 아이디 유무 조회
        if(userDAO.checkId(userVO.getUserId())){
            // 저장된 사용자의 정보를 불러옴
            UserVO userInfo = userDAO.userInfo(userVO.getUserId());
            // 사용자가 입력한 비밀번호와 저장된 사용자의 비밀번호를 비교
            if(!passwordEncoder.matches(userVO.getUserPw(), userInfo.getUserPw())){
                System.out.println("비밀번호가 일치하지 않습니다.");
                return false;
            }else if(userInfo.getStatus() == 1) {
                System.out.println("이미 탈퇴한 회원입니다.");
                return false;
            } else{
                userDAO.login(userVO);
                System.out.println("비밀번호가 일치합니다.");
                return true;
            }
        }else {
            // 해당 아이디가 없을 경우
            System.out.println("해당 아이디 존재하지 않음.");
            return false;
        }
    }

    // 아이디찾기
    public List<UserVO> idFind (String userPhoneNum){
        return userDAO.idFind(userPhoneNum);
    }

    // 동일한 전화번호의 아이디 갯수
    public int idFindCnt (String userPhoneNum){ return userDAO.idFindCnt(userPhoneNum); }

    // 비밀번호 찾기 : 아이디 유무 조회
    public boolean pwFind (String userId){ return userDAO.pwFind(userId); }

    // 비밀번호 찾기: 아이디 + 전화번호 + 이름 같아야 인증 가능
    public boolean pwFindAuth (UserVO userVO) { return userDAO.pwFindAuth(userVO); }

    // 비밀번호 변경
    public boolean pwUpdate (UserVO userVO) {
        String userPw = userVO.getUserPw();

        System.out.print("변경할 비밀번호: " + userPw);
        String encodedPw = passwordEncoder.encode(userPw);
        System.out.println("암호화된 비밀번호: " + encodedPw);
        // 암호화된 비밀번호로 다시 세팅
        userVO.setUserPw(encodedPw);

        return userDAO.pwUpdate(userVO);
    }

    // 회원 정보 조회
    public UserVO userInfo (String userId) {return  userDAO.userInfo(userId);}

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
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }

}

