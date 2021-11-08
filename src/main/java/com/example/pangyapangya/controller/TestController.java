package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
    
    @GetMapping("read")
    public String read(@RequestParam("tno") Long tno, Model model){
        model.addAttribute("item", testService.getRead(tno));
        model.addAttribute("imgs", testService.getReadImgs(tno));
        return "test/read";
    }

/*    @GetMapping("mainPage_test")
    public String mainPage_test(HttpSession session,@RequestParam("tno") Long tno){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU == null && sessionC == null){
            return "/user/login";
        }
        return "main/mainPage_test";
    }*/

    @GetMapping("readSuccess")
    public String readSuccess(){return "test/readSuccess";}

    @GetMapping("review")
    public String review(Model model){
        model.addAttribute("list",testService.getReviewBoardList());
        model.addAttribute("total",testService.getReviewBoardTotal());
        return "test/review";
    }

    @GetMapping("reviewinfo")
    public String reviewinfo(){return "test/reviewinfo";}

    @GetMapping("info")
    public String info(){return "test/info";}

    @GetMapping("test")
    public String test(){return "test/test";}
}
