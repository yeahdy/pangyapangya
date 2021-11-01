package com.example.pangyapangya.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class MyPageCeoController {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //    하위의 모든 테스트가 실행 전에 실행되도록 한다.
    @BeforeEach
    public void setUp(){
//        가짜 MVC에 WebApplicationContext를 전달한 후 환경을 생성한다.
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testBakery() throws Exception {
        String bno = mockMvc.perform(
                MockMvcRequestBuilders.post("/myPageCeo/bakeryRe")
                        .param("title", "테스트 새 글 제목")
                        .param("content", "테스트 새 글 내용")
                        .param("ceoId", "wnsrbod")
                        .param("ceoName", "한준규")
                        .param("bakeryName", "뜨레쥬르")
                        .param("bakeryZipcode", "1234")
                        .param("bakeryAddress", "주소")
                        .param("bakeryAddressDetail", "상세주소")
                        .param("bakeryPhoto", "사진")
        ).andReturn().getFlashMap().toString();

        log.info(bno);
    }

}
