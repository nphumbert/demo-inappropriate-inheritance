package com.nphumbert;

@FunctionalInterface
public interface HashProvider {

    String hash(String text);
}
