package com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.userservice;

import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.request.UserDetailRequestModel;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailRequestModel userDetails);
}
