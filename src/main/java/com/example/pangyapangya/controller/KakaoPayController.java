package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.KakaoPay;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Log4j
@Controller
@SessionAttributes("user_id")
@AllArgsConstructor
public class KakaoPayController {

    private KakaoPay kakaopay;


}
