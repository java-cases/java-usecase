package com.security.digest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.Objects;
import java.util.Optional;

public class CodecDigest {

    private CodecDigest() {
    }

    public static Optional<String> digest(DigestAlgorithms algorithms, String plainText) {
        Objects.requireNonNull(plainText);

        MessageDigest messageDigest =DigestUtils.getDigest(algorithms.getValue());
        byte[] ciphertext = messageDigest.digest(plainText.getBytes());

        return Optional.ofNullable(Hex.encodeHexString(ciphertext));
    }

    public static Optional<String> md5Hex(String plainText) {
        Objects.requireNonNull(plainText);

        String cipherText = DigestUtils.md5Hex(plainText);
        return Optional.ofNullable(cipherText);
    }

    public static Optional<String> sha1Hex(String plainText) {
        Objects.requireNonNull(plainText);

        String cipherText = DigestUtils.sha1Hex(plainText);
        return Optional.ofNullable(cipherText);
    }

    public static Optional<String> sha256Hex(String plainText) {
        Objects.requireNonNull(plainText);

        String cipherText = DigestUtils.sha256Hex(plainText);
        return Optional.ofNullable(cipherText);
    }
}
