package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.services.CEOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
@RequestMapping("/ceo/*")
@RequiredArgsConstructor
public class CEOController {
    private final CEOService ceoService;
    private String mainView = "redirect:/main/mainPage";

    /* 로그인 */
    @GetMapping("loginCEO")
    public String loginCEO(){ return "ceo/loginCEO"; }

    @PostMapping("loginCEO")
    public String loginCEO(CeoVO ceoVO, HttpServletRequest req, RedirectAttributes rttr){
        log.info("---------로그인-----------");
        log.info("ceoId: " + ceoVO.getCeoId());
        log.info("ceoPw: " + ceoVO.getCeoPw());
        log.info("--------------------------");

        HttpSession session = req.getSession(); // session 생성
        if(!ceoService.loginCEO(ceoVO)) {
            log.info("-------로그인 실패-------");
            session.setAttribute("sessionC", null);
            rttr.addAttribute("check", "false");
            return "ceo/loginCEO";
        }else{
            log.info("-------로그인 성공-------");
            CeoVO ceoInfo= ceoService.ceoInfo(ceoVO.getCeoId());
            session.setAttribute("sessionC", ceoInfo.getStatus());
            return mainView;
        }
    }


    /* 아이디 찾기 */
    @GetMapping("idFindCEO")
    public String idFindCEO(){ return "ceo/idFindCEO"; }

    /* 아이디 찾기 완료 */
    @GetMapping("idFindSuccessCEO")
    public String idFindSuccessCEO(){ return "ceo/idFindSuccessCEO"; }

    /* 비밀번호 찾기 */
    @GetMapping("pwFindCEO")
    public String pwFindCEO(){ return "ceo/pwFindCEO"; }

    /* 비밀번호 찾기 완료 */
    @GetMapping("pwFindSuccessCEO")
    public String pwFindSuccessCEO(){ return "ceo/pwFindSuccessCEO"; }


    /* 회원가입- 사장님 */
    @GetMapping("joinCEO")
    public String joinCEO(){ return "ceo/joinCEO"; }

    @PostMapping("createCEO")
    public String createCEO(@RequestParam Map<String,String> ceoVO_1, Model model){
        log.info("--------------------------");
        log.info("ceoVO_1: " + ceoVO_1.get("ceoId"));
        log.info("ceoVO_1: " + ceoVO_1.get("ceoPw"));
        log.info("ceoVO_1: " + ceoVO_1.get("ceoName"));
        log.info("ceoVO_1: " + ceoVO_1.get("phoneNum"));
        log.info("--------------------------");
        model.addAttribute("ceoVO_1",ceoVO_1);
        model.addAttribute("ceoId", ceoVO_1.get("ceoId"));
        model.addAttribute("ceoPw", ceoVO_1.get("ceoPw"));
        model.addAttribute("ceoName", ceoVO_1.get("ceoName"));
        model.addAttribute("phoneNum", ceoVO_1.get("phoneNum"));
        return "ceo/joinCEO2";
    }

    @GetMapping("joinCEO2")
    public String joinCEO2(){ return "ceo/joinCEO2"; }

    @PostMapping("createCEO2")
    public String createCEO2(CeoVO ceoVO, Model model){
        log.info("-----------------------------------------");
        log.info("createCEO2" + ceoVO.toString());
        log.info("-----------------------------------------");
        model.addAttribute("ceoVO", ceoVO);
        return "ceo/joinConfirmCEO";
    }

    /* 회원가입- 약관동의 */
    @PostMapping("joinConfirmCEO")
    public String joinConfirmCEO(CeoVO ceoVO){
        log.info("-----------------------------------------");
        log.info("joinConfirmCEO(사장님): " + ceoVO.toString());
        log.info("-----------------------------------------");
        ceoService.joinCEO(ceoVO);
        return "user/joinSuccess";
    }
}