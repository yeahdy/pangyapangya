package com.example.pangyapangya.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Slf4j
public class CommomExceptionAdvice {
    // @ExceptionHandler: 예외가 발생할때 제어하는 어노테이션
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model){
        log.error("Exception................." + e.getMessage());
        model.addAttribute("exception",e);  //Exception 뷰단에 보내기
        log.error(model.toString());    // model에 담긴 객체 출력하기
        return "error/errorPage";
    }

    /*
        500메세지는 Internal Server Error 이므로 @ExceptionHandler를 이용해서 처리가능
        404메세지는 잘못된 URL을 호출할 때 보이므로 NoHandlerFoundException으로 처리
     */

    // 404오류 처리
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)   //오류 status를 404로 유지한 채 에러페이지로 이동한다.
    public String handle404(NoHandlerFoundException e){
        return "error/error404Page";
    }

}
