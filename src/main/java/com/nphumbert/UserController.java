package com.nphumbert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
public class UserController extends BaseController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user: " + hash("user");
    }

}
