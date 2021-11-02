package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.beans.vo.Cart_shopName_VO;
import com.example.pangyapangya.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @GetMapping("cart")
    public String cart(){ return "mypage/cart"; }
    //cart


    @GetMapping("cartList")
    public String cartList(Model model){
        log.info("-------------------------------------");
        log.info("cartList");
        log.info("-------------------------------------");
        model.addAttribute("cartList", cartService.getCartList("kjy1234"));
        return "mypage/cart"; }

    @GetMapping("addCart")
    public String addCart(CartVO cartVO, Model model){
        log.info("-------------------------------------");
        log.info("addCart");
        log.info("-------------------------------------");

        cartService.addCart(cartVO);
        return "mypage/cart";
    }

   /* @GetMapping("getCart")
    public String getCart(String userId, Model model){
        log.info("-------------------------------------");
        log.info(userId+ "님의 장바구니" );
        log.info("-------------------------------------");

        model.addAttribute("cart", cartService.getCart(userId));
        return "mypage/cart";
    }*/

    @GetMapping("deleteCart")
    public String deleteCart(@RequestParam("cartNum") Long cartNum, RedirectAttributes rttr){
        log.info("-------------------------------------");
        log.info("delete"+ cartNum );
        log.info("-------------------------------------");

        if (cartService.deleteCart(cartNum)){
            rttr.addFlashAttribute("result", "success");
        }else{
            rttr.addFlashAttribute("result", "fail");
        }
        return "mypage/cart";
    }

    @GetMapping("updateCnt")
    public String updateCnt(@RequestParam("cartNum") Long cartNum, int breadCnt){
        log.info("-------------------------------------");
        log.info(cartNum+"번 장바구니 수량변경");
        log.info("-------------------------------------");

        cartService.updateCnt(cartNum, breadCnt);
        return "mypage/cart";
    }

    @GetMapping("test")
    public String test(@ModelAttribute("cart") CartVO cart){
        log.info("------------------------------------");
        log.info(cart.toString());
        log.info("------------------------------------");
        return "mypage/test";
    }

}
