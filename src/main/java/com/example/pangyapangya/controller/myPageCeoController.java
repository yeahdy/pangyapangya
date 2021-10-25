package com.example.pangyapangya.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myPageCeo/*")
@RequiredArgsConstructor
public class myPageCeoController {
    //마이페이지(사장님)-글 등록[빵집 소개]
    @GetMapping("bakery")
    public String myPageCeoBakery(){ return "myPageCeo/bakery"; }

    //마이페이지(사장님)-글 등록[원데이 클래스]
    @GetMapping("oneDay")
    public String myPageCeoOneDay(){ return "myPageCeo/oneDay"; }

    //마이페이지(사장님)-글 등록[빵 체험단]
    @GetMapping("exp")
    public String myPageCeoExp(){ return "myPageCeo/exp"; }

    //마이페이지(사장님)-내 글 보기[빵집 소개]
    @GetMapping("bakeryRe")
    public String myPageCeoBakeryRe(){ return "myPageCeo/bakeryRe"; }

    //마이페이지(사장님)-내 글 보기[원데이 클래스]
    @GetMapping("oneDayRe")
    public String myPageCeoOneDayRe(){ return "myPageCeo/oneDayRe"; }

    //마이페이지(사장님)-내 글 보기[빵 체험단]
    @GetMapping("expRe")
    public String myPageCeoExpRe(){ return "myPageCeo/expRe"; }

    //마이페이지(사장님)-내 정보 수정
    @GetMapping("edit")
    public String myPageCeoEdit(){ return "myPageCeo/edit"; }

    //마이페이지(사장님)-회원 탈퇴
    @GetMapping("delete")
    public String myPageCeoDelete(){ return "myPageCeo/delete"; }
}
