package com.ibreath.api;

import com.ibreath.resource.GetMeasureResource;
import com.ibreath.resource.PostMeasureResource;
import com.ibreath.service.MeasureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("Measure")
public class MeasureController {

    private MeasureService service;

    @ApiOperation("Get measure Data")
    @RequestMapping(value="/measure/10/{user}", method = RequestMethod.GET)
    public List<GetMeasureResource> getLast10Values(@PathVariable("user") String userId) {
        return service.getLast10Values(userId);
    }

    @ApiOperation("Post measure data")
    @RequestMapping(value="/measure/{user}", method = RequestMethod.POST)
    public PostMeasureResource post(
            @PathVariable("user") String userId,
            @ApiParam(
                    value= "Datas",
                    required = true) @RequestBody PostMeasureResource resource
    ) {
        return service.postMeasure(userId, resource);
    }


    @Autowired
    public void setService(MeasureService service) {
        this.service = service;
    }
}
