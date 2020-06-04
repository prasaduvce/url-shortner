package com.example.urlshortner.encode;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;

public class Base62Test {

    private Base62 base62 = new Base62();

    @Test
    public void test() {
        String val = "1001111001000011011111000100101111011001011";
        BigInteger bigInteger = new BigInteger(val, 2);
        System.out.println("bigInteger ===> "+bigInteger);
        String encode = base62.encode(bigInteger);
        System.out.println("encode ===> "+encode);
    }

    @Test
    public void testIdToShortUrl() {
        String val = "1001111001000011011111000100101111011001011";
        BigInteger bigInteger = new BigInteger(val, 2);
        System.out.println("bigInteger ===> "+bigInteger);
        String encode = base62.idToShortURL(12345678901L);
        System.out.println("encode ===> "+encode);
    }

    @Test
    public void testDecode() {
        String val = "1001111001000011011111000100101111011001011";
        BigInteger bigInteger = new BigInteger(val, 2);
        long decode = base62.decode("nDFndp");
        System.out.println("decode ===> "+decode);
    }

    @Test
    public void test1() throws NoSuchAlgorithmException {
        String encode = base62.md5Sum("http://www.facebook.com/prasaduvce");
        System.out.println("encode ===> "+encode);
        String substring = encode.substring(0, 43);
        System.out.println("encode ===> "+substring);
        BigInteger bigInteger = new BigInteger(substring, 2);
        System.out.println("bigInteger ===> "+bigInteger);
    }
}
