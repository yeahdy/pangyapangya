package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.dao.CartDAO;
import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.PageDTO;
import com.example.pangyapangya.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MypageController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final OrderService orderService;
    private final BakeryService bakeryService;
    private final TestingService testingService;


    //mypage_user
    @GetMapping("order")
    public String order(){ return "main/delivery"; }
    @GetMapping("bread_review")
    public String bread_review(){ return "mypage/bread_review"; }
    @GetMapping("oneDayClass_review")
    public String oneDayClass_review(){ return "mypage/oneDayClass_review"; }

    //마이페이지(일반 회원) - 내가 작성한 글 List(빵 체험단)
    @GetMapping("testing_review")
    public String testingReview( Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        log.info("-------------------------------");
        log.info(sessionU);
        log.info("-------------------------------");
        model.addAttribute("TestingReview", testingService.getTestingReview(sessionU));
        /*model.addAttribute("list", testingService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(testingService.getTotal(criteria), 10, criteria));*/
        return "mypage/testing_review";
    }


    /*@PostMapping("checkPassword")
    public String checkPassword(String password, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);
        if (!passwordEncoder.matches(userService.userInfo(sessionU).getUserPw(), password)){
            log.info("****************비밀번호 불일치****************");
            return "mypage/checkPassword_new";
        }
        return "mypage/modifyMyInfo";
    }*/

    @PostMapping("modifyMyInfo")
    public String modifyMyInfo(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);
        if(sessionU == null){
            return "/user/login";
        }
        model.addAttribute("userInfo", userService.userInfo(sessionU));

        return "mypage/modifyMyInfo";
    }

    @GetMapping("breadOrderList")
    public String breadOrderList(Model model, HttpSession session, @RequestParam("bno") Long bno){
        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);
        if(sessionU == null){
            return "/user/login";
        }
        model.addAttribute("orderList", orderService.getOrderList(sessionU));
        //shopName필요
        model.addAttribute("shopName", bakeryService.getBakeryName(bno));

        return "mypage/breadOrderList";
    }
    @GetMapping("oneDayClassList")
    public String oneDayClassList(){ return "mypage/oneDayClassList"; }
    @GetMapping("testingList")
    public String testingList(){ return "mypage/testingList"; }
    @GetMapping("myWriting_new")
    public String myWriting_new(){ return "mypage/myWriting_new"; }
    @GetMapping("checkPassword_new")
    public String checkPassword_new(){ return "mypage/checkPassword_new"; }

}
