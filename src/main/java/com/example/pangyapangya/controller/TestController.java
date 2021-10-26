package com.example.pangyapangya.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/test/*")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("list")
    public String list(){
        return "test/list";
    }

    @GetMapping("read")
    public String read(){return "test/read";}

    @GetMapping("readSuccess")
    public String readSuccess(){return "test/readSuccess";}

    @GetMapping("review")
    public String review(){return "test/review";}

    @GetMapping("reviewinfo")
    public String reviewinfo(){return "test/reviewinfo";}

    @GetMapping("info")
    public String info(){return "test/info";}
}
