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
public class breadListController {

    @GetMapping("breadList")
    public String breadList(){ return "main/breadList"; }

    @GetMapping("breadDetail")
    public String breadDetail(){ return "main/breadDetail"; }

    @GetMapping("delivery")
    public String delivery(){ return "main/delivery"; }
}
