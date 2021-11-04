package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.beans.vo.PageDTO;
import com.example.pangyapangya.services.BakeryService;
import com.example.pangyapangya.services.BreadDetailService;
import com.example.pangyapangya.services.CEOService;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class BreadDetailController {

    private final BakeryService bakeryService;
    private final UserService userService;
    private final CEOService ceoService;
    private final BreadDetailService breadDetailService;

    @GetMapping("breadList")
    public String breadList(Model model){
       model.addAttribute("list", bakeryService.breadList());
        return "main/breadList";
    }

    @GetMapping("breadDetail")
    public String breadDetail(@RequestParam("bno") Long bno, Model model){
        model.addAttribute("info", breadDetailService.getInfo(bno));
        return "main/breadDetail";
    }
    /*@GetMapping({"breadDetail", "modify"})
    public void breadDetail(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청 시 read 출력
        //modify 요청 시 modify 출력
        log.info("-------------------------------");
        log.info(reqType + " : " + bno);
        log.info("-------------------------------");

        model.addAttribute("ceo", bakeryService.getCeo(sessionC));
        model.addAttribute("bakery", bakeryService.get(bno));
        model.addAttribute("criteria", criteria);
    }

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
        return new RedirectView("breadDetail");
    }*/

}
