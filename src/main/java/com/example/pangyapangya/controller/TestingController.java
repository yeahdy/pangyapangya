package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.*;
import com.example.pangyapangya.services.ClassCeoService;
import com.example.pangyapangya.services.TestingService;
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

@Controller
@Slf4j
@RequestMapping("/myPageCeo/*")
@RequiredArgsConstructor
public class TestingController {

    private final TestingService testingService;

    //마이페이지(사장님)-글 등록[원데이 클래스]
    @GetMapping("exp")
    public String myPageCeoExp(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        model.addAttribute("ceo", testingService.getCeo(sessionC));
        return "myPageCeo/exp"; }


    @PostMapping("exp")
    public RedirectView exp(TestingVO testingVO, RedirectAttributes rttr){
        testingService.register(testingVO);
        rttr.addFlashAttribute("tno", testingVO.getTno());
        return new RedirectView("expRe");
    }

    //마이페이지(사장님) - 내가 작성한 글 List(빵 체험단)
    @GetMapping("expRe")
    public String expRe(Criteria criteria, Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        log.info("-------------------------------");
        log.info("expRe");
        log.info("-------------------------------");
        model.addAttribute("total", testingService.myTotal(sessionC));
        model.addAttribute("list", testingService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(testingService.getTotal(criteria), 10, criteria));
        return "myPageCeo/expRe";
    }

    //    여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.
    @GetMapping("expModify")
    public void expModify(@RequestParam("tno") Long tno, Criteria criteria, Model model, HttpServletRequest request, HttpSession session){
        String sessionC = (String)session.getAttribute("sessionC");

        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + tno);
        log.info("-------------------------------");

        model.addAttribute("ceo", testingService.getCeo(sessionC));
        model.addAttribute("testing", testingService.get(tno));
        model.addAttribute("criteria", criteria);
    }


    //    /modify 요청을 처리할 수 있는 비지니스 로직 작성
//    수정 성공시 result에 "success"를 담아서 전달한다.
//    단위 테스트로 View에 전달할 파라미터를 조회한다.
    @PostMapping("expModify")
    public RedirectView expModify(TestingVO testingVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("modify : " + testingVO.toString());
        log.info("-------------------------------");

        if(testingService.modify(testingVO)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("tno", testingVO.getTno());
        }
        return new RedirectView("expRe");
    }

    @GetMapping("testingRemove")
    public RedirectView testingRemove(@RequestParam("tno") Long tno, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove : " + tno);
        log.info("-------------------------------");

        /*List<BakeryFileVO> attachList = bakeryService.getAttachList(bno);*/

        if (testingService.remove(tno)) {
            /*deleteFiles(attachList);*/
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("expRe");
    }




    
    //    /remove 요청을 처리할 수 있는 비지니스 로직 작성
//    삭제 성공 시 result에 "success"를 flash에 담아서 전달한다.
//    삭제 실패 시 result에 "fail"을 flash에 담아서 전달한다.
//    단위 테스트로 전달할 파라미터를 조회한다.
    /*@PostMapping("remove")
    public RedirectView remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove : " + bno);
        log.info("-------------------------------");

        if (bakeryService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("oneDayRe");
    }*/

    //    게시글 첨부파일
    /*@GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TesingFileVO> getAttachList(Long tno){
        log.info("getAttachList " + tno);
        return testingService.getAttachList(tno);
    }*/

}



















