package com.nphumbert;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
public class ProfileController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "profile: " + hash("profile");
    }

    private String hash(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return Arrays.toString(md.digest(value.getBytes("UTF-8")));
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
