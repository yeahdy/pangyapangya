package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.KakaoPayReadyVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;
import java.util.UUID;

@Service
@Log4j
public class KakaoPay {

    private static final String HOST = "https://kapi.kakao.com";

    private static final String QUANTITY = "1"; //  주문 수량 고정
    private static final String TOTAL_AMOUNT = "3000";  //  가격 고정
    private static final String TAX_FREE_AMOUNT = "300";    //  제세세

    private static final String APPROVAL_URL = "http://localhost:10009/kakao/kakaoPaySuccess";  //  결제 성공 URL
    private static final String CANCEL_URL = "http://localhost:10009/kakao/kakaoPayCancel";  //  결제 취소 URL
    private static final String FAIL_URL = "http://localhost:10009/kakao/kakaoPayFail";  //  결제 실패 URL

    private static final String ITEM_NAME = "브라우니"; //  결제 상품명
    private static final String partner_order_id = UUID.randomUUID().toString();    //  주문 고유 번호 무작위 생성

    private KakaoPayReadyVO kakaoPayReadyVO;
    RestTemplate restTemplate = new RestTemplate();

    public static HttpHeaders headers() {
        //  서버로 요청할 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Athorization", "KakaoAK" + "cca5b8285b2bff699d32a4eff3c52ad7");
        headers.add("Accept", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        return headers;
    }

    public String kakaoPayReady(String user_id){
        //  서버로 요청 할 body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TCONETIME"); //  사업자 제휴 번호
        params.add("partner_order_id", partner_order_id);   //  주문 고유 번호
        params.add("partner_user_id", user_id);
        params.add("quantity", QUANTITY);
        params.add("total_amount", TOTAL_AMOUNT);
        params.add("tax_free_amount", TAX_FREE_AMOUNT);
        params.add("approval_url",APPROVAL_URL);
        params.add("cancel_url", CANCEL_URL);
        params.add("fail_url", FAIL_URL);

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers());
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            log.info("" + kakaoPayReadyVO);
            //성공시
            return kakaoPayReadyVO.getNext_redirect_pc_url();

        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        //  실패시
        return "pay";
    }
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String user_id) {
        // 서버로 요청할 Header
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", partner_order_id);
        params.add("partner_user_id", user_id); params.add("pg_token", pg_token);
        params.add("total_amount",TOTAL_AMOUNT);//금액

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers());

        try { KakaoPayApprovalVO kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("" + kakaoPayApprovalVO); return kakaoPayApprovalVO;
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
