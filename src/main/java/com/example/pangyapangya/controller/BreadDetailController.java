package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.BakeryVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.services.BakeryService;
import com.example.pangyapangya.services.BreadDetailService;
import com.example.pangyapangya.services.BreadDetailService;
import com.example.pangyapangya.services.CEOService;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String breadList(Model model, BakeryVO bakeryVO){
        model.addAttribute("list", bakeryService.breadList(bakeryVO.getKeyword()));
        return "main/breadList";
    }

    @GetMapping("breadDetail")
    public String breadDetail(@RequestParam("bno") Long bno, Model model, Criteria criteria){
        model.addAttribute("info", breadDetailService.getInfo(bno));
        model.addAttribute("replyList", breadDetailService.getListWithPaging(bno, criteria));
        /*model.addAttribute("reply", breadDetailService.getReply(bno));*/
        return "main/breadDetail";
    }

    @GetMapping("delivery")
    public String delivery(String userId, Model model){
        model.addAttribute("userInfo", userService.userInfo(userId));
        return "main/delivery";
    }

}
