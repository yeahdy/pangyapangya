package com.example.pangyapangya.controller;

import com.example.pangyapangya.beans.vo.UserVO;
import com.example.pangyapangya.services.UserService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/*
    [ Task ]		    [ URL ]			    [ Method ]		[ Parameter ]			    [ Form ]	[ URL이동 ]
    메인 페이지	        /main/mainPage		GET		        ???				            없음	    없음
    로그인		        /user/login		    POST		    userId, Pw, status		    있음	    이동
    아이디 찾기	        /user/idFind		POST		    user/ceoPhoneNum			있음	    이동
    아이디 찾기 완료	/user/idFindSuccess	POST		    user/ceoId, user/ceoName	없음	    없음
    비밀번호 찾기	    /user/pwFind		POST		    user/ceoId, user/ceoPhoneNum있음	    이동
    비밀번호 찾기 완료	/user/idFindSuccess	POST		    user/ceoPw			        없음        없음
    회원가입- 일반회원	/user/join		    POST		    userVO				        있음      	이동
    회원가입- 사장님	/user/joinCEO		POST		    ceoVO	정보 반반씩 처리?	있음	    이동
    회원가입- 사장님	/user/joinCEO2		POST		    ceoVO				        있음      	이동
    회원가입- 약관동의	/user/joinConfirm	X		        X				            없음      	없음
*/
@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private String mainView = "redirect:/main/mainPage";

    /* 로그인 */
    @GetMapping("login")
    public String login(){ return "user/login"; }

    @PostMapping("login")
    public RedirectView login(UserVO userVO, HttpServletRequest req, RedirectAttributes rttr){
        log.info("---------로그인-----------");
        log.info("ceoId: " + userVO.getUserId());
        log.info("ceoPw: " + userVO.getUserPw());
        log.info("--------------------------");

        HttpSession session = req.getSession(); // session 생성
        if(!userService.login(userVO)) {
            log.info("-------로그인 실패-------");
            session.setAttribute("sessionU", null);  // session 저장하기
            // 아이디 비번 틀렸을 경우
            rttr.addFlashAttribute("check", "false");
            return new RedirectView("login");
        }
        log.info("-------로그인 성공-------");
        UserVO userInfo= userService.userInfo(userVO.getUserId());
        session.setAttribute("sessionU", userInfo.getUserId()); //session 저장하기
        return new RedirectView("/main/mainPage");
    }

    /* 로그아웃 */
    @GetMapping("logout")
    public void logout(HttpServletRequest req){
        HttpSession session = req.getSession(false);    // false: 세션이 없을 경우 null 반환. 기본값 true
        if(session != null){
            session.invalidate();   //세션 삭제
        }
    }

    /* 아이디 찾기 */
    @GetMapping("idFind")
    public String idFind(){ return "user/idFind"; }

    /* 아이디 찾기 완료 */
    @PostMapping ("idFindSuccess")
    public RedirectView idFindSuccess(@RequestParam("userPhoneNum") String userPhoneNum, RedirectAttributes rttr){
        // 사용자가 입력한 전화번호를 받아 list로 뽑는다.
        List<UserVO> userList = userService.idFind(userPhoneNum);
        // 전화번호에 따른 아이디 갯수
        int idFindCnt = userService.idFindCnt(userPhoneNum);
        if(userList != null){
            log.info("----------------- 유저 리스트 -----------------");
            log.info(userList.toString());
            log.info("아이디 갯수: " + idFindCnt);
            log.info("-----------------------------------------------");
            rttr.addFlashAttribute("userList", userList);
            rttr.addFlashAttribute("idFindCnt", idFindCnt);
            if(idFindCnt == 0){
                rttr.addFlashAttribute("resultId", 0);
                return new RedirectView("login");
            }
        }
        return new RedirectView("idFindSuccess");
    }

    @GetMapping("idFindSuccess")
    public String idFindSuccess(){ return "user/idFindSuccess"; }


    /* 비밀번호 찾기 */
    @GetMapping("pwFind")
    public String pwFind(){ return "user/pwFind"; }

    @PostMapping("pwFind")
    public RedirectView pwFind(UserVO userVO, RedirectAttributes rttr){
        log.info("----------------- 사용자 입력 정보 -----------------");
        log.info("아이디: " + userVO.getUserId());
        log.info("이름: " + userVO.getUserName());
        log.info("전화번호: " + userVO.getUserPhoneNum());
        log.info("-----------------------------------------------");
        // 만약 사용자가 입력한 정보가 DB와 일치할 경우 → 비밀번호 변경
        if(userService.pwFindAuth(userVO)){
            log.info("-------------- DB와 입력정보 일치 --------------");
            rttr.addFlashAttribute("userId", userVO.getUserId());
            return new RedirectView("pwFindSuccess");
        }else{
            log.info("-------------- DB와 입력정보 불일치 --------------");
            rttr.addFlashAttribute("result", 0);
            return new RedirectView("pwFind");
        }
    }

    /* 비밀번호 찾기 완료 */
    @GetMapping("pwFindSuccess")
    public String pwFindSuccess(){ return "user/pwFindSuccess"; }

    @PostMapping("pwFindSuccess")
    public RedirectView pwFindSuccess(UserVO userVO, RedirectAttributes rttr){
        // 받아와야할것? 회원의 아이디, 변경할 비밀번호
        log.info("--------------- 사용자 입력 정보 --------------");
        log.info("아이디: " + userVO.getUserId());
        log.info("변경할 비밀번호: " + userVO.getUserPw());
        log.info("-----------------------------------------------");
        // pwFind에서 넘겨받은 아이디를 통해 해당 회원의 비밀번호 변경하기 → 서비스에서 전달받은 비밀번호 암호화하기
        if(userService.pwUpdate(userVO)){
            log.info("--------- 비밀번호 변경 완료 ---------");
            rttr.addFlashAttribute("resultPw", 0);
            return new RedirectView("login");
        }else{
            log.info("--------- 비밀번호 변경 실패 ---------");
            return new RedirectView("pwFindSuccess");
        }
    }

    /* 회원가입 */
    @GetMapping("join")
    public String join(){ return "user/join";}

    /* 회원가입 */
    @PostMapping("createUser")
    public String createUser(UserVO userVO, Model model){
        log.info("-----------------------------------------");
        log.info("createUser: " + userVO.toString());
        log.info("-----------------------------------------");

       model.addAttribute("userVO", userVO);
        return "user/joinConfirm";
    }

    /* 회원가입- 약관동의 */
    @PostMapping("joinConfirm")
    public String joinConfirm(UserVO userVO){
        log.info("-----------------------------------------");
        log.info("joinConfirm(일반 회원): " + userVO.toString());
        log.info("-----------------------------------------");
        userService.join(userVO);
        return "user/joinSuccess";
    }

    /* 회원가입 완료 */
    @GetMapping("joinSuccess")
    public String joinSuccess(HttpSession session){
        String sessionU = (String)session.getAttribute("sessionU");
        String sessionC = (String)session.getAttribute("sessionC");
        if(sessionU != null || sessionC != null){
            return "main/mainPage";
        }
        return "user/joinSuccess";
    }

    /* 로딩페이지 */
    @GetMapping("loading")
    public String loading(){
        return "user/loading";
    }

    /* ************************************* Rest Api 로 카카오톡 로그인 ************************************* */

    // 카카오톡 로그인 연동 (인가코드 발급)
    @RequestMapping(value = "/login/getKakaoAuthUrl")
    public @ResponseBody
    String getKakaoAuthUrl(
            HttpServletRequest request) throws Exception {
        System.out.println("--------- 카카오연동 들어옴 ---------");

        String reqUrl =
                "https://kauth.kakao.com/oauth/authorize"
                        + "?client_id=56ca7f16524140167e76230ff811876e"
                        + "&redirect_uri=http://localhost:10009/user/loading"
                        + "&response_type=code";

        return reqUrl;
    }

    // 카카오 연동정보 조회 + DB에 회원 정보넣기
    @RequestMapping(value = "/selectMyAccessTocken")
    public String oauthKakao(
            @RequestParam(value = "code", required = false) String code
            , HttpServletRequest req) throws Exception {

        System.out.println("--------- 카카오 정보조회 들어옴 ---------");

        // 발급받은 인가코드를 통해 토큰 발급받기
        System.out.println("#########" + code);
        String access_Token = getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);


        // 토큰을 이용해 사용자 정보 가져오기
        HashMap<String, Object> userInfo = getUserInfo(access_Token);
        System.out.println("------- access_Token ------- : " + access_Token);
        System.out.println("------- userInfo ------- : " + userInfo.get("email"));
        System.out.println("------- nickname ------- : " + userInfo.get("nickname"));

        // 가져온 회원 정보 DB에 넣어 회원가입 시키기
        UserVO userVO = new UserVO();
        String kakao_email = (String)userInfo.get("email"); // 회원 아이디
        String kakao_nickname = (String)userInfo.get("nickname");   // 회원 이름

        // 만약 DB에 해당 회원의 ID가 없다면 회원가입 시키기
        if(!userService.checkId(kakao_email)){
            log.info("유저 회원가입");
            userVO.setUserId(kakao_email);
            userVO.setUserName(kakao_nickname);
            userService.joinKakao(userVO);
        }
        // 만약 이미 회원가입 된 회원이라면? 로그인하기
        HttpSession session = req.getSession(); // session 생성
        session.setAttribute("sessionU", kakao_email); //session 저장하기

        return "main/mainPage"; //본인 원하는 경로 설정
    }

    //토큰발급
    public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=56ca7f16524140167e76230ff811876e");  //본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:10009/user/loading");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }

    //유저정보조회
    public HashMap<String, Object> getUserInfo (String access_Token) {

        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();

            userInfo.put("accessToken", access_Token);
            userInfo.put("nickname", nickname);
            userInfo.put("email", email);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }

}

