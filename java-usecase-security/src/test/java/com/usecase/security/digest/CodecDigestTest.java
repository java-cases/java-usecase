package com.usecase.security.digest;

import org.junit.Test;

public class CodecDigestTest {

    @Test
    public void digest() {
        String plainText = "plainText";
        String ciphertext = CodecDigest.digest(DigestAlgorithms.MD5, plainText).orElse("");

        System.out.println(ciphertext);
    }

    @Test
    public void md5Hex() {
        String plainText = "plainText";
        String ciphertext = CodecDigest.md5Hex(plainText).orElse("");

        System.out.println(ciphertext);
    }

    @Test
    public void sha1Hex() {
        String plainText = "plainText";
        String ciphertext = CodecDigest.sha1Hex(plainText).orElse("");

        System.out.println(ciphertext);
    }

    @Test
    public void sha256Hex() {
        String plainText = "plainText";
        String ciphertext = CodecDigest.sha256Hex(plainText).orElse("");

        System.out.println(ciphertext);
    }
}