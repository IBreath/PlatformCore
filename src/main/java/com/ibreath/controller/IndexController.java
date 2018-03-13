package com.ibreath.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseBody
    public List<String> testIBreath() {
        List<String> models = new ArrayList<>();
        models.add("test1");
        models.add("test2");
        models.add("test3");
        return models;
    }

}
