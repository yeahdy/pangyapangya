package com.example.pangyapangya.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class mainController {

    @GetMapping("index")
    public String index(){ return "main/index"; }

    @GetMapping("elements")
    public String elements(){
        return "main/elements";
    }

    @GetMapping("generic")
    public String generic(){ return "main/generic"; }

    @GetMapping("mainPage")
    public String mainPage(){ return "main/mainPage"; }

    @GetMapping("mainPage_test")
    public String mainPage_test(){ return "main/mainPage_test"; }
}
