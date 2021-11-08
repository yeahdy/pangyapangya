package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.*;
import com.example.pangyapangya.services.ClassCeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/myPageCeo/*")
@RequiredArgsConstructor
public class ClassCeoController {

    private final ClassCeoService classCeoService;

    //마이페이지(사장님)-글 등록[원데이 클래스]
    @GetMapping("oneDay")
    public String myPageCeoOneDay(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        model.addAttribute("ceo", classCeoService.getCeo(sessionC));
        return "myPageCeo/oneDay"; }


    @PostMapping("oneDay")
    public RedirectView oneDay(ClassCeoVO classCeoVO, RedirectAttributes rttr){
        classCeoService.register(classCeoVO);
        rttr.addFlashAttribute("bno", classCeoVO.getBno());
        return new RedirectView("oneDayRe");
    }

    //마이페이지(사장님) - 내가 작성한 글(원데이 클래스)
    @GetMapping("oneDayRe")
    public String oneDayRe(Criteria criteria, Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        log.info("-------------------------------");
        log.info("oneDayRe");
        log.info("-------------------------------");
        model.addAttribute("total", classCeoService.myTotal(sessionC));
        model.addAttribute("list", classCeoService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(classCeoService.getTotal(criteria), 10, criteria));
        return "myPageCeo/oneDayRe";
    }

    //    여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.
    @GetMapping("oneDayModify")
    public void oneDayModify(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request, HttpSession session){
        String sessionC = (String)session.getAttribute("sessionC");

        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");

        model.addAttribute("ceo", classCeoService.getCeo(sessionC));
        model.addAttribute("oneDay", classCeoService.get(bno));
        model.addAttribute("criteria", criteria);
    }


    //    /modify 요청을 처리할 수 있는 비지니스 로직 작성
//    수정 성공시 result에 "success"를 담아서 전달한다.
//    단위 테스트로 View에 전달할 파라미터를 조회한다.
    @PostMapping("oneDayModify")
    public RedirectView oneDayModify(ClassCeoVO classCeoVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("modify : " + classCeoVO.toString());
        log.info("-------------------------------");

        if(classCeoService.modify(classCeoVO)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("bno", classCeoVO.getBno());
        }
        return new RedirectView("oneDayRe");
    }







    //    /remove 요청을 처리할 수 있는 비지니스 로직 작성
//    삭제 성공 시 result에 "success"를 flash에 담아서 전달한다.
//    삭제 실패 시 result에 "fail"을 flash에 담아서 전달한다.
//    단위 테스트로 전달할 파라미터를 조회한다.
    @GetMapping("oneDayRemove")
    public RedirectView oneDayRemove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove : " + bno);
        log.info("-------------------------------");

        /*List<BakeryFileVO> attachList = bakeryService.getAttachList(bno);*/

        if (classCeoService.remove(bno)) {
            /*deleteFiles(attachList);*/
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("oneDayRe");
    }

    //    게시글 첨부파일
    /*@GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BakeryFileVO> getAttachList(Long bno){
        log.info("getAttachList " + bno);
        return bakeryService.getAttachList(bno);
    }*/

}



















