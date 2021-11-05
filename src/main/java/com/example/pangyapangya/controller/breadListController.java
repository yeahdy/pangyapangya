package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.BreadDetailService;
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
public class breadListController {
    private final BreadDetailService breadDetailService;

    @GetMapping("breadList")
    public String breadList(){ return "main/breadList"; }

    @GetMapping("breadDetail")
    public String breadDetail(@RequestParam("bno") Long bno, Model model){
        model.addAttribute("info", breadDetailService.getInfo(bno));
        return "main/breadDetail";
    }

    @GetMapping("delivery")
    public String delivery(){ return "main/delivery"; }


}
