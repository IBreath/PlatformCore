package com.ibreath.controller;

import com.ibreath.resource.dto.MeasureDto;
import com.ibreath.service.MeasureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/measures")
@Api("Measure")
public class MeasureController {

    private MeasureService service;

    @ApiOperation("Get measure Data")
    @GetMapping("/10/{user}")
    public List<MeasureDto> getLast10Values(@PathVariable("user") String userId) {
        return service.getLast10Values(userId);
    }

    @ApiOperation("Post measure data")
    @PostMapping("/{user}")
    public MeasureDto post(
            @PathVariable("user") String userId,
            @ApiParam(
                    value= "Datas",
                    required = true) @RequestBody MeasureDto resource
    ) {
        return service.postMeasure(userId, resource);
    }


    @Autowired
    public void setService(MeasureService service) {
        this.service = service;
    }
}
