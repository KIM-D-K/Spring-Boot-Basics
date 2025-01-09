package com.wikibooks.chapter1.controller;

import com.wikibooks.chapter1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DIController {

    MyService myService;

    @Autowired
    public DIController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/di/hello")
    public String getHello() {
        return myService.getHello();
    }

}

// 생성자를 통한 의존성 주입 (Spring은 4.3 이후 버전은 생성자를 통해 의존성을 주입할 때 @Autowired 어노테이션 생략 가능 하지만 가독성을 위해서 명시하는 것이 좋음.)