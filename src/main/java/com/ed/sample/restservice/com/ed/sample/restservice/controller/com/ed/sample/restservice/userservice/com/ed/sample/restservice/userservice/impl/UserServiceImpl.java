package com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.userservice.com.ed.sample.restservice.userservice.impl;

import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.request.UserDetailRequestModel;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.response.UserRest;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.userservice.UserService;
import com.ed.sample.restservice.com.ed.sample.restservice.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String,UserRest> users;
    Utils utils;


    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId,returnValue);

        return returnValue;
    }

}
