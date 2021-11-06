package com.example.pangyapangya.services;

import com.example.pangyapangya.beans.vo.KakaoPayApprovalVO;
import com.example.pangyapangya.beans.vo.KakaoPayReadyVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Service
@Log4j
public class KakaoPay {
    private static final String HOST = "https://kapi.kakao.com";

    private KakaoPayReadyVO kakaoPayReadyVO;

    public String kakaoPayReady(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new  HttpHeaders();
        headers.add("Authorization", "KakaoAK" + "cca5b8285b2bff699d32a4eff3c52ad7");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "브라우니");
        params.add("quantity", "1");
        params.add("total_amount", "2100");
//        params.add("tax_free_amount", "100");
        params.add("approval_url", "http://localhost:10009/kakao/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:10009/kakao/kakaoPayCancel");
        params.add("fail_url", "http://localhost:10009/kakao/kakaoPaySuccessFail");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);

            log.info("" + kakaoPayReadyVO);

            return kakaoPayReadyVO.getNext_redirect_pc_url;

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //  실패시
        return "/pay";
    }
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {

        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");

        RestTemplate restTemplate = new RestTemplate();

        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "cca5b8285b2bff699d32a4eff3c52ad7");
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("total_amount", "2100");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            KakaoPayApprovalVO kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("" + kakaoPayApprovalVO);

            return kakaoPayApprovalVO;

        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
