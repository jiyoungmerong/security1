package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping({ "", "/" })
    public String index() {
        // 머스테 이용. 기본 폴더 : src/main/resources/
        // 뷰 리졸버 설정 : templates (prefix), .mustache (suffix)
        return "index";
    }
}