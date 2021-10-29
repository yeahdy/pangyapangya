package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.dao.MainDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {
    private final MainDAO mainDAO;
/*
    // 인증번호(전화번호, 인증번호)
    public void certifiedPhoneNumber(String phoneNumber, String cerNum) {

        String api_key = "NCSQNB02FGNIJWVJ";
        String api_secret = "XKUECSFOHIBWYHNANPTKSRVMTZQLEIPP";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phoneNumber);    // 수신전화번호
        params.put("from", "01085362558");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
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

    }*/
}
