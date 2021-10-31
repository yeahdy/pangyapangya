package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /* 로그인 */
    @GetMapping("login")
    public String login(){ return "user/login"; }

    /* 아이디 찾기 */
    @GetMapping("idFind")
    public String idFind(){ return "user/idFind"; }

    /* 아이디 찾기 완료 */
    @GetMapping("idFindSuccess")
    public String idFindSuccess(){ return "user/idFindSuccess"; }

    /* 비밀번호 찾기 */
    @GetMapping("pwFind")
    public String pwFind(){ return "user/pwFind"; }

    /* 비밀번호 찾기 완료 */
    @GetMapping("pwFindSuccess")
    public String pwFindSuccess(){ return "user/pwFindSuccess"; }

    /* 회원가입 */
    @GetMapping("join")
    public String join(){ return "user/join";}

    /* 회원가입 */
    @PostMapping("createUser")
    public String createUser(UserVO userVO, Model model){
        log.info("-----------------------------------------");
        log.info("createUser: " + userVO.toString());
        log.info("-----------------------------------------");

       model.addAttribute("userVO", userVO);
        return "user/joinConfirm";
    }

    /* 회원가입- 약관동의 */
    @PostMapping("joinConfirm")
    public String joinConfirm(UserVO userVO, CeoVO ceoVO){
        log.info("-----------------------------------------");
        log.info("joinConfirm(일반 회원): " + userVO.toString());
        log.info("status: " + userVO.getStatus());
        log.info("-----------------------------------------");
            userService.join(userVO);
        return "user/joinSuccess";
    }

    /* 회원가입 완료 */
    @GetMapping("joinSuccess")
    public String joinSuccess(){ return "user/joinSuccess";}
}