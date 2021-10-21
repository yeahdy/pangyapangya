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
    @GetMapping("myPageCeoBakery")
    public String myPageCeoBakery(){ return "myPageCeo/myPageCeoBakery"; }

    //마이페이지(사장님)-글 등록[원데이 클래스]
    @GetMapping("myPageCeoOneDay")
    public String myPageCeoOneDay(){ return "myPageCeo/myPageCeoOneDay"; }

    //마이페이지(사장님)-글 등록[빵 체험단]
    @GetMapping("myPageCeoExp")
    public String myPageCeoExp(){ return "myPageCeo/myPageCeoExp"; }

    //마이페이지(사장님)-내 글 보기[빵집 소개]
    @GetMapping("myPageCeoBakeryRe")
    public String myPageCeoBakeryRe(){ return "myPageCeo/myPageCeoBakeryRe"; }

    //마이페이지(사장님)-내 글 보기[원데이 클래스]
    @GetMapping("myPageCeoOneDayRe")
    public String myPageCeoOneDayRe(){ return "myPageCeo/myPageCeoOneDayRe"; }

    //마이페이지(사장님)-내 글 보기[빵 체험단]
    @GetMapping("myPageCeoExpRe")
    public String myPageCeoExpRe(){ return "myPageCeo/myPageCeoExpRe"; }

    //마이페이지(사장님)-내 정보 수정
    @GetMapping("myPageCeoEdit")
    public String myPageCeoEdit(){ return "myPageCeo/myPageCeoEdit"; }

    //마이페이지(사장님)-회원 탈퇴
    @GetMapping("myPageCeoDelete")
    public String myPageCeoDelete(){ return "myPageCeo/myPageCeoDelete"; }
}
