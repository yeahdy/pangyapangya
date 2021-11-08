package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.BakeryService;
import com.example.pangyapangya.services.ClassCeoService;
import com.example.pangyapangya.services.TestService;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;
/*
    [ Task ]		    [ URL ]			    [ Method ]		[ Parameter ]			    [ Form ]	[ URL이동 ]
    메인 페이지	        /main/mainPage		GET		        ???				            없음	    없음
    로그인		        /user/login		    POST		    userId, Pw, status		    있음	    이동
    아이디 찾기	        /user/idFind		POST		    user/ceoPhoneNum			있음	    이동
    아이디 찾기 완료	/user/idFindSuccess	POST		    user/ceoId, user/ceoName	없음	    없음
    비밀번호 찾기	    /user/pwFind		POST		    user/ceoId, user/ceoPhoneNum있음	    이동
    비밀번호 찾기 완료	/user/idFindSuccess	POST		    user/ceoPw			        없음        없음
    회원가입- 일반회원	/user/join		    POST		    userVO				        있음      	이동
    회원가입- 사장님	/user/joinCEO		POST		    ceoVO	정보 반반씩 처리?	있음	    이동
    회원가입- 사장님	/user/joinCEO2		POST		    ceoVO				        있음      	이동
    회원가입- 약관동의	/user/joinConfirm	X		        X				            없음      	없음
*/
@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class mainController {
    private final UserService userService;
    private final BakeryService bakeryService;
    private final TestService testService;
    private final ClassCeoService classCeoService;

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
    public String breadList(Model model){
        // 오늘의 빵
        model.addAttribute("breadList", bakeryService.breadList_main());
//        // 원데이 클래스
        model.addAttribute("classList", classCeoService.classList_main());
        // 빵 체험단(모집)
        model.addAttribute("tasting", testService.mainTest());
        // 빵 체험단(리뷰)
        model.addAttribute("tastingRe", testService.mainReview());
        /*model.addAttribute("reviewTotal", testService) 리뷰갯수*/
        return "main/mainPage";
    }



    @GetMapping("mainPage_test")
    public String mainPage_test(HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        return "main/mainPage_test";
    }


    /* footer */
    @GetMapping("footer")
    public String footer(){ return "main/footer"; }


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