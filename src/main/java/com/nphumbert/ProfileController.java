package com.nphumbert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final HashProvider hashProvider;

    @Autowired
    public ProfileController(HashProvider hashProvider) {
        this.hashProvider = hashProvider;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "profile: " + hashProvider.hash("profile");
    }

}
