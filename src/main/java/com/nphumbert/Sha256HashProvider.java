package com.nphumbert;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
public class Sha256HashProvider implements HashProvider {

    @Override
    public String hash(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return Arrays.toString(md.digest(value.getBytes("UTF-8")));
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}