package com.example.urlshortner.encode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Base62 {
    private static char[] encodeChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    public String encode(BigInteger id) {
        StringBuilder hashString = new StringBuilder();
        while (id.compareTo(BigInteger.ZERO) > 0) {
            id = id.mod(BigInteger.valueOf(62));
            hashString.append(encodeChars[id.intValue()]);
            id = id.divide(BigInteger.valueOf(62));
        }
        return hashString.reverse().toString();
    }

    public String idToShortURL(long n)
    {
        // Map to store 62 possible characters
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Map<Long, Character> characterLongMap = new HashMap<>();
        for (int i = 0;i<map.length; i++) {
            characterLongMap.put(Long.valueOf(i), map[i]);
        }

        StringBuilder shorturl = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            long l = n % 62;
            shorturl.append(characterLongMap.get(l));
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    public long decode(String str) {
        long id = 0;
        for (int i=0;i<str.length();i++) {
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                id = id*62 + str.charAt(i) - 'a';
            }
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                id = id*62 + str.charAt(i) - 'A'+26;
            }
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                id = id*62 + str.charAt(i) - '0'+52;
            }
        }

        return id;
    }

    public String md5Sum(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = messageDigest.digest(str.getBytes());
        BigInteger no = new BigInteger(1, bytes);
        return no.toString(2);
    }
}
