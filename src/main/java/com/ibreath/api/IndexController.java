package com.ibreath.api;

import org.springframework.web.bind.annotation.*;

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
        return models;
    }

}
