package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.CartVO;
import com.example.pangyapangya.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class CartRestController {
    private final CartService cartService;

    @RequestMapping(value = "{cartNum}")
    public ResponseEntity<String> deleteCart(@PathVariable("cartNum") Long cartNum) throws UnsupportedEncodingException {
        ResponseEntity<String> entity = null;
        log.info("deleteCart 번호: " + cartNum);
        try {
            cartService.deleteCart(cartNum);
            /* 삭제 성공 */
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            // 삭제 실패
            log.info("------------------- 장바구니 삭제 오류 -------------------");
            entity = new ResponseEntity<String >(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 메세지 리턴
        return entity;

    }


}
