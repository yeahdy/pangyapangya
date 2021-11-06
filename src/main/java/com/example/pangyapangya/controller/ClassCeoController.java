package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.*;
import com.example.pangyapangya.services.ClassCeoService;
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

@Controller
@Slf4j
@RequestMapping("/myPageCeo/*")
@RequiredArgsConstructor
public class ClassCeoController {

    private final ClassCeoService classCeoService;

    //마이페이지(사장님)-글 등록[원데이 클래스]
    @GetMapping("oneDay")
    public String myPageCeoOneDay(Model model, String ceoId){
        ceoId="wnsrbod";
        model.addAttribute("ceo", classCeoService.getCeo(ceoId));
        return "myPageCeo/oneDay"; }


    @PostMapping("oneDay")
    public RedirectView oneDay(ClassCeoVO classCeoVO, RedirectAttributes rttr){
        classCeoService.register(classCeoVO);
        rttr.addFlashAttribute("bno", classCeoVO.getBno());
        return new RedirectView("oneDayRe");
    }

    //마이페이지(사장님) - 내가 작성한 글(원데이 클래스)
    @GetMapping("oneDayRe")
    public String oneDayRe(Criteria criteria, Model model){

        log.info("-------------------------------");
        log.info("oneDayRe");
        log.info("-------------------------------");
        model.addAttribute("total", classCeoService.myTotal("wnsrbod"));
        model.addAttribute("list", classCeoService.getList(criteria));
        model.addAttribute("pageMaker", new PageDTO(classCeoService.getTotal(criteria), 10, criteria));
        return "myPageCeo/oneDayRe";
    }

    //내가 작성한 글에서 원데이클래스 게시글 수정
    @PostMapping("oneDayModify")
    public RedirectView oneDayModify(ClassCeoVO classCeoVO, RedirectAttributes rttr){
        log.info("-------------------------------");
        log.info("modify : " + classCeoVO.toString());
        log.info("-------------------------------");

        if(classCeoService.modify(classCeoVO)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("bno", classCeoVO.getBno());
        }
        return new RedirectView("oneDayModify");
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


    //    여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.
   /* @GetMapping({"oneDayRe", "modify"})
    public void read(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request, CeoVO ceoVO){
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");
        ceoVO.setCeoId("wnsrbod");
        model.addAttribute("ceo", classCeoService.getCeo("wnsrbod"));
        model.addAttribute("bakery", classCeoService.get(bno));
        model.addAttribute("criteria", criteria);
    }*/

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
    public List<BakeryFileVO> getAttachList(Long bno){
        log.info("getAttachList " + bno);
        return bakeryService.getAttachList(bno);
    }*/

}



















