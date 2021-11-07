package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.*;
import com.example.pangyapangya.services.BakeryService;
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
public class MyPageCeoController {

    private final BakeryService bakeryService;

    //마이페이지(사장님)-글 등록[빵집 소개]
    @GetMapping("bakery")
    public String myPageCeoBakery(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        model.addAttribute("ceo", bakeryService.getCeo(sessionC));
        return "myPageCeo/bakery";
    }

    //마이페이지(사장님)-글 등록[빵집 소개]
    /*@GetMapping("bakeryModify")
    public String bakeryModify(@RequestParam("bno") Long bno, HttpServletRequest request,  Model model, BakeryVO bakeryVO, Criteria criteria){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        model.addAttribute("ceo", bakeryService.getCeo(bakeryVO.getCeoId()));
        model.addAttribute("bakery", bakeryService.get(bno));
        model.addAttribute("criteria", criteria);
        return "myPageCeo/bakeryModify";
    }*/


    //마이페이지(사장님)-내 정보 수정
    @GetMapping("edit")
    public String myPageCeoEdit(){ return "myPageCeo/edit"; }

    //마이페이지(사장님)-회원 탈퇴
    @GetMapping("delete")
    public String myPageCeoDelete(){ return "myPageCeo/delete"; }

    @PostMapping("bakery")
    public RedirectView bakery(BakeryVO bakeryVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("bakery : " + bakeryVO.toString());
        log.info("-------------------------------");

        if(bakeryVO.getAttachList() != null){
            bakeryVO.getAttachList().forEach(attach -> log.info(attach.toString()));
        }
        bakeryService.register(bakeryVO);
//        쿼리 스트링으로 전달
//        rttr.addAttribute("bno", boardVO.getBno());
//        세션의 flash영역을 이용하여 전달
        rttr.addFlashAttribute("bno", bakeryVO.getBno());
//        RedirectView를 사용하면 redirect방식으로 전송이 가능하다.
        return new RedirectView("bakeryRe");
    }

    @GetMapping("bakeryRe")
    public String bakeryRe(Criteria criteria, Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        log.info("-------------------------------");
        log.info("bakeryRe");
        log.info("-------------------------------");
        model.addAttribute("total", bakeryService.myTotal(sessionC));
        model.addAttribute("list", bakeryService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(bakeryService.getTotal(criteria), 10, criteria));
        return "myPageCeo/bakeryRe";
    }

    //    여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.
   /* @GetMapping({"read", "modify"})
    public void read(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request, CeoVO ceoVO){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");
        ceoVO.setCeoId("wnsrbod");
        model.addAttribute("ceo", bakeryService.getCeo("wnsrbod"));
        model.addAttribute("bakery", bakeryService.get(bno));
        model.addAttribute("criteria", criteria);
    }*/

    //    /modify 요청을 처리할 수 있는 비지니스 로직 작성
//    수정 성공시 result에 "success"를 담아서 전달한다.
//    단위 테스트로 View에 전달할 파라미터를 조회한다.
    @PostMapping("modify")
    public RedirectView modify(BakeryVO bakeryVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("modify : " + bakeryVO.toString());
        log.info("-------------------------------");

        if(bakeryService.modify(bakeryVO)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("bno", bakeryVO.getBno());
        }
        return new RedirectView("bakeryModify");
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
        return new RedirectView("bakeryRe");
    }*/

    @GetMapping("register")
    public void register(){}

    //    게시글 첨부파일
    @GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BakeryFileVO> getAttachList(Long bno){
        log.info("getAttachList " + bno);
        return bakeryService.getAttachList(bno);
    }

}



















