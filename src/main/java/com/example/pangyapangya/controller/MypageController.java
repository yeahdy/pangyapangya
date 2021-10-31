package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.dao.CartDAO;
import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MypageController {


    //mypage_user
//    @GetMapping("cart")
//    public String cart(){ return "mypage/cart"; }
    private final CartService cartService;
    //cart
    @GetMapping("cartList")
    public String cartList(Model model){
        log.info("-------------------------------------");
        log.info("cartList");
        log.info("-------------------------------------");
        model.addAttribute("cartList", cartService.getCart("kjy1234"));
        return "mypage/cart"; }

    @GetMapping("addCart")
    public String addCart(CartVO cartVO, Model model){
        log.info("-------------------------------------");
        log.info("addCart");
        log.info("-------------------------------------");

        cartService.addCart(cartVO);
        return "mypage/cart";
    }

    @GetMapping("getCart")
    public String getCart(@RequestParam("userId")String userId, Model model){
        log.info("-------------------------------------");
        log.info(userId+ "님의 장바구니" );
        log.info("-------------------------------------");

        model.addAttribute("cart", cartService.getCart(userId));
        return "mypage/cart";
    }

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



    @GetMapping("order")
    public String order(){ return "mypage/order"; }
    @GetMapping("bread_review")
    public String bread_review(){ return "mypage/bread_review"; }
    @GetMapping("oneDayClass_review")
    public String oneDayClass_review(){ return "mypage/oneDayClass_review"; }
    @GetMapping("testing_review")
    public String testing_review(){ return "mypage/testing_review"; }
    @GetMapping("modifyMyInfo")
    public String modifyMyInfo(){ return "mypage/modifyMyInfo"; }
    /*@GetMapping("checkPassword")
    public String checkPassword(){ return "mypage/checkPassword"; }*/
    @GetMapping("breadOrderList")
    public String breadOrderList(){ return "mypage/breadOrderList"; }
    @GetMapping("oneDayClassList")
    public String oneDayClassList(){ return "mypage/oneDayClassList"; }
    @GetMapping("testingList")
    public String testingList(){ return "mypage/testingList"; }
    @GetMapping("myWriting_new")
    public String myWriting_new(){ return "mypage/myWriting_new"; }
    @GetMapping("checkPassword_new")
    public String checkPassword_new(){ return "mypage/checkPassword_new"; }
    @GetMapping("test")
    public String test(@ModelAttribute("cart") CartVO cart){
        log.info("------------------------------------");
        log.info(cart.toString());
        log.info("------------------------------------");
        return "mypage/test";
    }
}
