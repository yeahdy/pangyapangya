package com.example.pangyapangya.controller;

import com.example.pangyapangya.services.CEOService;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    private final CEOService ceoService;

    /* 아이디 중복검사(일반회원) */
    @GetMapping("/idCheck/{userId}")
    public String checkId(@PathVariable String userId){
        boolean check= userService.checkId(userId);
        return check + "";
    }

    /* 아이디 중복검사(사장님) */
    @GetMapping("/idCheckCEO/{userId}")
    public String checkIdCEO(@PathVariable String userId){
        boolean check= ceoService.checkIdCEO(userId);
        return check + "";
    }



    // @RequestBody 를 사용하게 되면 content-Type이 application/json 에 해당된다.
    // 어노테이션을 붙이지 않으면 @ModelAttribute가 암묵적으로 사용되기 때문에 content-Type이 application/x-www-form-urlencoded 이다.
    //[참고] https://blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221853596497&redirect=Dlog&widgetTypeCall=true&directAccess=false
    /* 회원가입 */
    /*
    ※ 페이지이동 하려면 어떻게 해야하지..?
    @PostMapping("create")
    public String create(UserVO userVO){
        try {
            userService.join(userVO);
            log.info("UserVO: " + userVO);
        } catch (Exception e) {
            log.info("join RestController 오류");
            log.info(e.getMessage());
        }
        return "redirect:/joinConfirm";
    }
    */


}