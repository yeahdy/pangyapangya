package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.beans.vo.CeoVO;
import com.example.pangyapangya.services.CEOService;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    //cart
   /* @GetMapping("cart")
    public String cart(){ return "mypage/cart"; }*/



    /* @GetMapping("getCart")
    public String getCart(String userId, Model model){
        log.info("-------------------------------------");
        log.info(userId+ "님의 장바구니" );
        log.info("-------------------------------------");

        model.addAttribute("cart", cartService.getCart(userId));
        return "mypage/cart";
    }*/

    /*수정된 getCart*/
    @GetMapping("cart")
    public String cartList(Model model, HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);
        if(sessionU == null){
            return "/user/login";
        }
        List<CartVO> cartList = cartService.getCartList(sessionU);
        log.info("-------------------------------------");
        log.info("cartList: " + cartList.toString());
        log.info("-------------------------------------");

//        String shopName = ceoService.ceoInfo(cart)
        model.addAttribute("cartList", cartList);
        return "mypage/cart";
    }

    @GetMapping("addCart")
    public String addCart(CartVO cartVO, Model model){
        log.info("-------------------------------------");
        log.info("addCart");
        log.info("-------------------------------------");

        cartService.addCart(cartVO);
        return "mypage/cart";
    }


    /* 추가 해야할 것 : 장바구니 모두 비우기
    * service까지 해놓음 */



    @GetMapping("test")
    public String test(Model model){
        log.info("-------------------------------------");
        log.info("cartList");
        log.info("-------------------------------------");
        model.addAttribute("cartList", cartService.getCartList("hds1234"));
        return "mypage/test";
    }

}
