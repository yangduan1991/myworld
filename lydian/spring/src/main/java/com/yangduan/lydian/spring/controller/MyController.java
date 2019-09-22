package com.yangduan.lydian.spring.controller;

import com.yangduan.lydian.spring.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/1")
public class MyController {
    private final MyService service;

    @Autowired
    public MyController(MyService service) {
        this.service = service;
    }

    @RequestMapping(value = "/news")
    public Map<String, Object> getNewsById(@RequestParam("id") long id) {
        return service.getNewsById(id);
    }
}
