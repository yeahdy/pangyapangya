package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.KakaoPay;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Log4j
@Controller
@AllArgsConstructor
public class KakaoPayController {

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;


    @GetMapping("kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("kakaoPay")
    public String kakaoPay(HttpSession httpSession) {
        log.info("kakaoPay post............................................");

        return "redirect:" + kakaopay.kakaoPayReady();

    }

    @GetMapping("kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));

    }

}
