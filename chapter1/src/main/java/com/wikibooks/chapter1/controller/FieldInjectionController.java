package com.wikibooks.chapter1.controller;

import com.wikibooks.chapter1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {

    @Autowired
    private MyService myService;

}

// 필드 객체 선언을 통한 의존성 주입