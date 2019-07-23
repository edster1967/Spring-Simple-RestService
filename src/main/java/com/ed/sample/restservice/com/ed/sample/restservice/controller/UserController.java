package com.ed.sample.restservice.com.ed.sample.restservice.controller;

import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.exceptions.UserServiceException;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.request.UpdateUserDetailRequestModel;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.request.UserDetailRequestModel;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.response.UserRest;
import com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String,UserRest> users;

    @Autowired
    UserService userService;

    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "Get users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

//    @GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//    public UserRest getUser(@PathVariable String userId) {
//        UserRest returnValue = new UserRest();
//        returnValue.setEmail("test1@test.com");
//        returnValue.setFirstName("Edward");
//        returnValue.setLastName("Tester");
//        return returnValue;
//    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

       if(true) throw new UserServiceException("Ed Threw a new error into this thing");

        if(users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId,storedUserDetails);

        return storedUserDetails;

    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
       users.remove(userId);
       return ResponseEntity.noContent().build();
    }


}
