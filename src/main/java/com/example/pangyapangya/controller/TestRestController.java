package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.RequestDTO;
import com.example.pangyapangya.beans.vo.TestingRequestVO;
import com.example.pangyapangya.beans.vo.TestingReviewBoardVO;
import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.services.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/testrest/*")
public class TestRestController {
    private final TestService testService;

    @GetMapping("/testrest/{temp}")
    public List<TestingVO> addList(@PathVariable("temp") int temp){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return testService.addData(temp);
    }

    @PostMapping(value = "/check", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody TestingRequestVO requestVO) throws UnsupportedEncodingException {
        log.info("requestVO : "+requestVO);
        if(testService.checkRe(requestVO) != 0){
            return new ResponseEntity<>(new String("이미 신청하신 체험단입니다.".getBytes(), "UTF-8"), HttpStatus.OK);
        }else if(testService.checkApplyCnt(requestVO.getUserId())==1){
            return new ResponseEntity<>(new String("신청은 하루에 한번만 가능합니다.".getBytes(), "UTF-8"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new String("pass".getBytes(), "UTF-8"), HttpStatus.OK);

    }

}
