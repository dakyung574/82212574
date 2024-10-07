package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    public String getUserNum(String urlString) throws MalformedURLException {
        log.info("url: {}", urlString);
        URL url = new URL(urlString);
        log.info("url.getHost(): {}", url.getHost());

        // 정규 표현식 패턴
        String pattern = "sampleapp1-(\\d+)\\.ce-aa\\.kubepia\\.net";

        // 패턴 컴파일
        Pattern r = Pattern.compile(pattern);

        // 매칭 수행
        Matcher m = r.matcher(urlString);

        if (m.find()) {
            // 첫 번째 그룹(괄호 안의 내용)을 반환
            return m.group(1);
        } else {
            return "Employee ID not found";
        }
    }
}
