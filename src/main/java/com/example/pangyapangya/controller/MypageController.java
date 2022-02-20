package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MypageController {
    private final UserService userService;

    /* 주문내역 */
    @GetMapping("breadOrderList")
    public String breadOrderList(){ return "mypage/breadOrderList"; }
    @GetMapping("oneDayClassList")
    public String oneDayClassList(){ return "mypage/oneDayClassList"; }
    @GetMapping("testingList")
    public String testingList(){ return "mypage/testingList"; }

    /* 내 글 보기 */
    @GetMapping("bread_review")
    public String bread_review(){ return "mypage/bread_review"; }
    @GetMapping("oneDayClass_review")
    public String oneDayClass_review(){ return "mypage/oneDayClass_review"; }
    @GetMapping("testing_review")
    public String testing_review(){ return "mypage/testing_review"; }


    /* 회원 정보수정 비밀번호 확인*/
    @GetMapping("checkPassword_new")
    public String checkPassword_new(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        model.addAttribute("user", userService.userInfo(sessionU));
        return "mypage/checkPassword_new";
    }

    @PostMapping("checkPassword_new")
    public RedirectView checkPassword_new(UserVO userVO, HttpSession session, RedirectAttributes rttr){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return new RedirectView("/user/login");
        }
        if(userService.login(userVO)){
            log.info("비밀번호 일치");
            return new RedirectView("modifyMyInfo");
        } else{
            rttr.addFlashAttribute("check", "false");
            return new RedirectView("checkPassword_new");
        }
    }

    /* 회원 정보수정 */
    @GetMapping("modifyMyInfo")
    public String modifyMyInfo(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        if(sessionU == null){ return "/user/login"; }
        UserVO userVO = userService.userInfo(sessionU);
        log.info( "userVO 정보: "+ userVO.toString());
        model.addAttribute("userInfo",userService.userInfo(sessionU));
        return "mypage/modifyMyInfo";
    }

    @PostMapping("edit")
    public RedirectView edit(RedirectAttributes rttr, UserVO userVO, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){ return new RedirectView("login"); }

        // 회원정보 수정하기
        log.info("userVO 정보수정: " + userVO.toString());
        if(userService.userUpdate(userVO) & userService.pwUpdate(userVO)){
            rttr.addFlashAttribute("check", "true");
        }
        return new RedirectView("modifyMyInfo");
    }

    /* 회원탈퇴 */
    @GetMapping("userDelete")
    public String myPageCeoDelete(HttpSession session, Model model){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        model.addAttribute("user", userService.userInfo(sessionU));
        return "mypage/userDelete";
    }

    @PostMapping("userDelete")
    public RedirectView delete(UserVO userVO, HttpServletRequest req, RedirectAttributes rttr){
        HttpSession session = req.getSession(); // session 생성
        if(userService.login(userVO)){
            userService.userDelete(userVO.getUserId()); // 회원탈퇴 계정으로 만들기(status == 1)
            rttr.addFlashAttribute("check", "true");
            session.invalidate();
            return new RedirectView("/main/mainPage");
        }else{
            rttr.addFlashAttribute("check", "false");
            return new RedirectView("userDelete");
        }

    }

    @GetMapping("myWriting_new")
    public String myWriting_new(){ return "mypage/myWriting_new"; }

}