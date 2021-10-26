package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class mainController {
    private final MainService mainService;

    @GetMapping("index")
    public String index(){ return "main/index"; }

    @GetMapping("elements")
    public String elements(){
        return "main/elements";
    }

    @GetMapping("generic")
    public String generic(){ return "main/generic"; }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    /* 헤더 */
    @GetMapping("header")
    public String header(){ return "main/header"; }

    /* 메인페이지 */
    @GetMapping("mainPage")
    public String mainPage(){ return "main/mainPage"; }

    @GetMapping("mainPage_test")
    public String mainPage_test(){ return "main/mainPage_test"; }

    /* footer */
    @GetMapping("footer")
    public String footer(){ return "main/footer"; }

    /* 로그인 */
    @GetMapping("login")
    public String login(){ return "main/login"; }

    /* 인증번호 */
    @GetMapping("/main/execute")
    public @ResponseBody String sendSMS(String userPhoneNum) {
        // 5자리 인증번호 만들기
        Random random  = new Random();
        String numStr = "";
        for(int i=0; i<5; i++) {
            String ranNum = Integer.toString(random.nextInt(10));   // 0부터 9까지 랜덤으로 숫자를 뽑는다
            numStr += ranNum;   // 랜덤으로 나온 숫자를 하나씩 담는다.
        }

        System.out.println("수신자 번호 : " + userPhoneNum);
        System.out.println("인증번호 : " + numStr);
        mainService.certifiedPhoneNumber(userPhoneNum,numStr);
        return numStr;
    }


    /* 아이디 찾기 */
    @GetMapping("idFind")
    public String idFind(){ return "main/idFind"; }

    /* 아이디 찾기 완료 */
    @GetMapping("idFindSuccess")
    public String idFindSuccess(){ return "main/idFindSuccess"; }

    /* 비밀번호 찾기 */
    @GetMapping("pwFind")
    public String pwFind(){ return "main/pwFind"; }

    /* 비밀번호 찾기 완료 */
    @GetMapping("pwFindSuccess")
    public String pwFindSuccess(){ return "main/pwFindSuccess"; }

    /* 회원가입- 일반회원 */
    @GetMapping("join")
    public String join(){ return "main/join"; }

    /* 회원가입- 사장님 */
    @GetMapping("joinCEO")
    public String joinCEO(){ return "main/joinCEO"; }

    @GetMapping("joinCEO2")
    public String joinCEO2(){ return "main/joinCEO2"; }

    /* 회원가입- 약관동의 */
    @GetMapping("joinConfirm")
    public String joinConfirm(){ return "main/joinConfirm"; }

    /* 회원가입- 약관동의: 서비스 이용약관 동의 팝업창 */
    @GetMapping("rule")
    public String rule(){ return "main/rule"; }

    /* 회원가입- 약관동의: 개인정보 처리방침 팝업창 */
    @GetMapping("privacy")
    public String privacy(){ return "main/privacy"; }

}