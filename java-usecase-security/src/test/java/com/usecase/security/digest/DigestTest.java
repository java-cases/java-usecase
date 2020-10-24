package com.usecase.security.digest;

import org.junit.Test;

public class DigestTest {

    @Test
    public void digestMD5() {
        String plainText = "plainText";
        String ciphertext = Digest.digest(DigestAlgorithms.MD5, plainText).orElse("");

        System.out.println(ciphertext);
    }

    @Test
    public void digestSHA1() {
        String plainText = "plainText";
        String ciphertext = Digest.digest(DigestAlgorithms.SHA_1, plainText).orElse("");

        System.out.println(ciphertext);
    }

    @Test
    public void digestSHA256() {
        String plainText = "plainText";
        String ciphertext = Digest.digest(DigestAlgorithms.SHA_256, plainText).orElse("");

        System.out.println(ciphertext);
    }
}