package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.TestingVO;
import com.example.pangyapangya.services.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/testrest/*")
public class TestRestController {
    private final TestService testService;

    @GetMapping("/testrest/{temp}")
    public List<TestingVO> addList(@PathVariable("temp") int temp){
        return testService.addData(temp);
    }
}
