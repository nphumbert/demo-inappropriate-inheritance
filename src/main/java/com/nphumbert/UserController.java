package com.nphumbert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final HashProvider hashProvider;

    @Autowired
    public UserController(HashProvider hashProvider) {
        this.hashProvider = hashProvider;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user: " + hashProvider.hash("user");
    }

}
