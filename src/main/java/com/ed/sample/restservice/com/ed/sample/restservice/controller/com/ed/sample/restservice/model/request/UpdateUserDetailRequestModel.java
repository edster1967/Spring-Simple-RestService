package com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.request;

import javax.validation.constraints.NotNull;

public class UpdateUserDetailRequestModel {
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
