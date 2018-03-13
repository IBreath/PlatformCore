package com.ibreath.controller;

import com.ibreath.resource.dto.UserDto;
import com.ibreath.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api("User Controller")
public class UserController {

    private UserService service;

    @ApiOperation("Get an user information")
    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("userId") String userId) throws Exception {
        return service.getUser(userId);
    }

    @ApiOperation("Create an user")
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public UserDto post(
            @ApiParam(value= "Data", required = true)
            @Valid @RequestBody UserDto resource
    ) throws Exception {
        return service.createUser(resource);
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }
}
