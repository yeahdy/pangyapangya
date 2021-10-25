package com.example.pangyapangya.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
@RequestMapping("/class/*")
@RequiredArgsConstructor
public class classController {

    @GetMapping("classMain")
    public String classMain(){ return "class/classMain"; }

    @GetMapping("classApply")
    public String classApply(){ return "class/classApply"; }

    @GetMapping("classDetail")
    public String classDetail(){ return "class/classDetail"; }

    @GetMapping("practice")
    public String practice(){ return "class/practice"; }

    @GetMapping("practice01")
    public String practice01(){ return "class/practice01"; }

    @GetMapping("classPay")
    public String classPay(){ return "class/classPay"; }

}
