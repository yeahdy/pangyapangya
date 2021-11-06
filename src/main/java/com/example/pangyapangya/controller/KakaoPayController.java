package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.KakaoPay;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
@SessionAttributes("user_id")
public class KakaoPayController {

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;


    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpSession httpSession) {
        String user_id = (String) httpSession.getAttribute("user_id");

        log.info("kakaoPay post............................................");

        return "redirect:" + kakaopay.kakaoPayReady(user_id);

    }

    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, HttpSession httpSession) {
        String user_id = (String) httpSession.getAttribute("user_id");
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, user_id));
    }

}
