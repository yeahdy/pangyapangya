package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MypageRestController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /*@RequestMapping(value = "password", method = RequestMethod.POST)
    public ResponseEntity<String> modifyMyInfo(HttpSession session, @PathVariable("password") String password) throws UnsupportedEncodingException{
        ResponseEntity<String> entity = null;

        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);

        try {
            if (passwordEncoder.matches(userService.userInfo(sessionU).getUserPw(), password)){
                entity = new ResponseEntity<String>("success", HttpStatus.OK);
            }
            else{
                entity = new ResponseEntity<String>("success", HttpStatus.OK);
                *//*entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);*//*
            }
        } catch (Exception e) {
            // 오류
            log.info("------------------- (정보수정)비밀번호 오류 -------------------");
            entity = new ResponseEntity<String >(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        return entity;
        }*/
    @RequestMapping(value = "password", method = RequestMethod.POST)
    public ResponseEntity<String> modifyMyInfo(HttpSession session, @PathVariable("password") String password) throws UnsupportedEncodingException{
        ResponseEntity<String> entity = null;

        String sessionU = (String)session.getAttribute("sessionU");
        log.info("session 회원아이디: " + sessionU);

        try {
            if (passwordEncoder.matches(userService.userInfo(sessionU).getUserPw(), password)){
                entity = new ResponseEntity<String>("success", HttpStatus.OK);
            }
            else{
                entity = new ResponseEntity<String>("success", HttpStatus.OK);
                entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // 오류
            log.info("------------------- (정보수정)비밀번호 오류 -------------------");
            entity = new ResponseEntity<String >(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        return entity;
        }
    }




//    @RequestMapping(value = "{cartNum}")
//    public ResponseEntity<String> deleteCart(@PathVariable("cartNum") Long cartNum) throws UnsupportedEncodingException {
//        ResponseEntity<String> entity = null;
//        log.info("deleteCart 번호: " + cartNum);
//        try {
//            cartService.deleteCart(cartNum);
//            /* 삭제 성공 */
//            entity = new ResponseEntity<String>("success", HttpStatus.OK);
//        } catch (Exception e) {
//            // 삭제 실패
//            log.info("------------------- 장바구니 삭제 오류 -------------------");
//            entity = new ResponseEntity<String >(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//        // 삭제 처리 메세지 리턴
//        return entity;

