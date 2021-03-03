package br.com.alura.forum.utils;


import lombok.Singleton;

import java.security.SecureRandom;
import java.util.Objects;

public class Utils {
    private static Utils instance = null;

    public static Utils getInstance() {
        if (Objects.isNull(instance)) instance = new Utils();
        return instance;
    }

    public String randomString(Integer len) {
        if (Objects.isNull(len)) len = 5;
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
