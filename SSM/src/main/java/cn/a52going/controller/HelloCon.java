package cn.a52going.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloCon {

    @RequestMapping("/hello")
    String Hello() {
        System.out.println(1/0);
        return "hello";
    }
}
