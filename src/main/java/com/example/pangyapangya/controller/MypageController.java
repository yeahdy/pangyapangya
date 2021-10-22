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
public class MypageController {

    //mypage_user
    @GetMapping("mypage")
    public String mypage(){ return "main/mypage"; }
    @GetMapping("cart")
    public String cart(){ return "main/cart"; }
    @GetMapping("order")
    public String order(){ return "main/order"; }
    @GetMapping("bread_review")
    public String bread_review(){ return "main/bread_review"; }
    @GetMapping("oneDayClass_review")
    public String oneDayClass_review(){ return "main/oneDayClass_review"; }
    @GetMapping("testing_review")
    public String testing_review(){ return "main/testing_review"; }
    @GetMapping("modifyMyInfo")
    public String modifyMyInfo(){ return "main/modifyMyInfo"; }
    @GetMapping("mypage_new")
    public String mypage_new(){ return "main/mypage_new"; }
    @GetMapping("checkPassword")
    public String checkPassword(){ return "main/checkPassword"; }
    @GetMapping("breadOrderList")
    public String breadOrderList(){ return "main/breadOrderList"; }
    @GetMapping("myWriting")
    public String myWriting(){ return "main/myWriting"; }
    @GetMapping("myWriting_new")
    public String myWriting_new(){ return "main/myWriting_new"; }
    @GetMapping("checkPassword_new")
    public String checkPassword_new(){ return "main/checkPassword_new"; }
}
