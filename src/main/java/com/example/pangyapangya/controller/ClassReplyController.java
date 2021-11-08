package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.ClassReplyFileVO;
import com.example.pangyapangya.beans.vo.ClassReplyPageDTO;
import com.example.pangyapangya.beans.vo.ClassReplyVO;
import com.example.pangyapangya.beans.vo.Criteria;
import com.example.pangyapangya.services.ClassReplyService;
import com.example.pangyapangya.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ClassReplyController {
    private final ClassReplyService classReplyService;
    private final UserService userService;

//    댓글 등록
//    브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다.
//    consumes : Ajax를 통해 전달받은 데이터의 타입
//    produces : Ajax의 success:function(result)에 있는 result로 전달할 데이터 타입
//    @ResponseBody : @Controller에서 REST API를 구현하기 위해서 사용된다.

    //    문자열을 전달할 때 한글이 깨지지 않게 하기 위해서는 text/plain; charset=utf-8을 작성한다.
//    ResponseEntity : 서버의 상태 코드, 응답 메세지 등을 담을 수 있는 타입이다.
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ClassReplyVO classReplyVO, HttpSession session) throws UnsupportedEncodingException {


        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
//        model.addAttribute("sessionU", sessionU);

        classReplyVO.setUserId(sessionU);

        log.info("dddd");
        int replyCount = classReplyService.register(classReplyVO);
        log.info("ClassReplyVO : " + classReplyVO);
        log.info("REPLY INSERT COUNT : " + replyCount);
        return replyCount == 1 ?
                new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //    게시글 댓글 전체 조회
    @GetMapping("pages/{bno}/{page}")
    public ClassReplyPageDTO getList(@PathVariable("bno") Long bno, @PathVariable("page") int page){
        log.info("getList............");
        Criteria criteria = new Criteria(page, 10);
        log.info(criteria.toString());
        return classReplyService.getList(bno, criteria);
    }

    //    댓글 조회
//    URI에 댓글 번호만 작성한다.
//    전달받은 rno를 JSON으로 리턴한다.
    @GetMapping("{rno}")
    public ClassReplyVO get(@PathVariable("rno") Long rno){
        log.info("get............");
        return classReplyService.get(rno);
    }
//
//    @GetMapping("register")
//    public void register(){}

//    //    게시글 첨부파일
//    @GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<ClassReplyFileVO> getAttachList(Long rno){
//        log.info("getAttachList " + rno);
//        return classReplyService.getAttachList(rno);
//    }


    //    /remove 요청을 처리할 수 있는 비지니스 로직 작성
//    삭제 성공 시 result에 "success"를 flash에 담아서 전달한다.
//    삭제 실패 시 result에 "fail"을 flash에 담아서 전달한다.
//    단위 테스트로 전달할 파라미터를 조회한다.
//    @PostMapping("remove")
//    public RedirectView remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
//        log.info("-------------------------------");
//        log.info("remove : " + bno);
//        log.info("-------------------------------");
//
//        List<AttachFileVO> attachList = boardService.getAttachList(bno);
//
//        if (boardService.remove(bno)) {
//            deleteFiles(attachList);
//            rttr.addFlashAttribute("result", "success");
//        } else {
//            rttr.addFlashAttribute("result", "fail");
//        }
//        return new RedirectView("list");
//    }



}
