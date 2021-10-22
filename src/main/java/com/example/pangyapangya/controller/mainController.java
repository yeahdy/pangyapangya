package com.example.pangyapangya.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class mainController {

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

    /* 로그인 */
    @GetMapping("login")
    public String login(){ return "main/login"; }

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

    /* 회원가입 */
    @GetMapping("join")
    public String join(){ return "main/join"; }

    /* 회원가입- 약관동의 */
    @GetMapping("joinConfirm")
    public String joinConfirm(){ return "main/joinConfirm"; }


}