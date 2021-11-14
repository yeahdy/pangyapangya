package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.PageDTO;
import com.example.pangyapangya.services.ClassCeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/class/*")
@RequiredArgsConstructor
public class ClassController {

    private final ClassCeoService classCeoService;

    @GetMapping("practice")
    public String practice(){ return "class/practice"; }

    @GetMapping("classPay")
    public String classPay(){ return "class/classPay"; }


    // 원데이클래스 메인페이지
    @GetMapping("classMain")
    public String classMain(Criteria criteria, Model model){
        log.info("-------------------------------");
        log.info("list");
        log.info("-------------------------------");
        model.addAttribute("list", classCeoService.getAllList());
        model.addAttribute("pageMaker", new PageDTO(classCeoService.getTotal(criteria), 10, criteria));
        return "class/classMain";
    }

    //    여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.
    @GetMapping("classDetail")
    public String classDetail(@RequestParam("bno") Long bno, Model model, HttpServletRequest request){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");

        model.addAttribute("class", classCeoService.get(bno));
//        model.addAttribute("criteria", criteria);

        return "class/classDetail";
    }


    @GetMapping("classApply")
    public String classApply(@RequestParam("bno") Long bno, Model model, RedirectAttributes rttr, HttpSession session, HttpServletRequest request){
//        HttpSession session = request.getSession(); // session 생성

        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");

        if(sessionU == null && sessionC == null){
            return "/user/login";
        }

        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");

        model.addAttribute("pay", classCeoService.get(bno));
//        model.addAttribute("criteria", criteria);

        return "class/classApply";
    }

}
