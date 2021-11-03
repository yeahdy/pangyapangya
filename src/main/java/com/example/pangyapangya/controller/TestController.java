package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/test/*")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("list", testService.read());
        model.addAttribute("total", testService.getTotal());
        return "test/list";
    }

//    @GetMapping({"read", "modify"})
//    public void read(@RequestParam("bno") Long bno, Criteria criteria, Model model, HttpServletRequest request){
//        String reqURI = request.getRequestURI();
//        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
//        //read 요청 시 read 출력
//        //modify 요청 시 modify 출력
//        log.info("-------------------------------");
//        log.info(reqType + " : " + bno);
//        log.info("-------------------------------");
//
//        model.addAttribute("board", boardService.get(bno));
//        model.addAttribute("criteria", criteria);
//    }
    @GetMapping("read")
    public String read(@RequestParam("tno") Long tno, Model model){
        model.addAttribute("item", testService.getRead(tno));
        return "test/read";
    }

    @GetMapping("readSuccess")
    public String readSuccess(){return "test/readSuccess";}

    @GetMapping("review")
    public String review(){return "test/review";}

    @GetMapping("reviewinfo")
    public String reviewinfo(){return "test/reviewinfo";}

    @GetMapping("info")
    public String info(){return "test/info";}

    @GetMapping("test")
    public String test(){return "test/test";}
}
