package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.TestingReviewBoardVO;
import com.example.pangyapangya.beans.vo.TestingReviewVO;
import com.example.pangyapangya.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class mainController {
    private final UserService userService;
    private final BakeryService bakeryService;
    private final TestService testService;
    private final ClassCeoService classCeoService;

    /* 헤더 */
    @GetMapping("header")
    public String header(){ return "main/header"; }

    /* 메인페이지 */
    @GetMapping("mainPage")
    public String breadList(Model model){
        // 오늘의 빵
        model.addAttribute("breadList", bakeryService.breadList_main());
        // 원데이 클래스
        model.addAttribute("classList", classCeoService.classList_main());
        // 빵 체험단(모집)
        model.addAttribute("tasting", testService.mainTest());
        // 빵 체험단(리뷰 게시글)
        model.addAttribute("tastingRe", testService.mainReview());

        return "main/mainPage";
    }

    /* 빵 체험단 리뷰- 댓글1 */
    @ResponseBody
    @GetMapping("getTastingReviews1")
    public List<TestingReviewVO> getTastingReviews1 (){
        List<TestingReviewBoardVO> tastingRe= testService.mainReview();
        Long getTno1 = tastingRe.get(0).getTno();
        log.info("첫번째 게시글번호: " + getTno1);
        return testService.getTastingReviews(getTno1);
    }
    /* 빵 체험단 리뷰- 댓글2 */
    @ResponseBody
    @GetMapping("getTastingReviews2")
    public List<TestingReviewVO> getTastingReviews2 (){
        List<TestingReviewBoardVO> tastingRe= testService.mainReview();
        Long getTno2 = tastingRe.get(1).getTno();
        log.info("두번째 게시글번호: " + getTno2);
        return testService.getTastingReviews(getTno2);
    }
    /* 빵 체험단 리뷰- 댓글3 */
    @ResponseBody
    @GetMapping("getTastingReviews3")
    public List<TestingReviewVO> getTastingReviews3 (){
        List<TestingReviewBoardVO> tastingRe= testService.mainReview();
        Long getTno3 = tastingRe.get(2).getTno();
        log.info("세번째 게시글번호: " + getTno3);
        return testService.getTastingReviews(getTno3);
    }

    /* footer */
    @GetMapping("footer")
    public String footer(){ return "main/footer"; }


    /* 인증번호 */
    @ResponseBody
    @GetMapping("/main/execute")
    public String sendSMS(String userPhoneNum) {
        // 5자리 인증번호 만들기
        Random random  = new Random();
        String numStr = "";
        for(int i=0; i<5; i++) {
            String ranNum = Integer.toString(random.nextInt(10));   // 0부터 9까지 랜덤으로 숫자를 뽑는다
            numStr += ranNum;   // 랜덤으로 나온 숫자를 하나씩 담는다.
        }

        System.out.println("수신자 번호 : " + userPhoneNum);
        System.out.println("인증번호 : " + numStr);

        // 문자 보내기
        userService.certifiedPhoneNumber(userPhoneNum , numStr);
        return numStr;
    }

    /* 회원가입- 약관동의: 서비스 이용약관 동의 */
    @GetMapping("rule")
    public String rule(){ return "main/rule"; }

    /* 회원가입- 약관동의: 개인정보 처리방침 */
    @GetMapping("privacy")
    public String privacy(){ return "main/privacy"; }

}