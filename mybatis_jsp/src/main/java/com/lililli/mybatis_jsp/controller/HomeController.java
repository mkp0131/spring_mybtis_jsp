package com.lililli.mybatis_jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lililli.mybatis_jsp.service.HomeService;
import com.lililli.mybatis_jsp.service.HomeVO;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/")
@Slf4j
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping(value="/")
    public String getHome(Model model) {

        List<HomeVO> list = homeService.getHomeList();
        log.info("### 가져온 리스트: " + list);
        log.info("레기온ID: " + list.get(0).getRegionId());
        model.addAttribute("list", list);

        return "home";
    }
}