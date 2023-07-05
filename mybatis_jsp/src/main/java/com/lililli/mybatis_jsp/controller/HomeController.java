package com.lililli.mybatis_jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lililli.mybatis_jsp.service.HomeService;


@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping(value="/")
    public String getHome() {

        List<?> list = homeService.getHomeList();
        System.out.println("### 가져온 리스트: " + list);

        return "home";
    }
}
