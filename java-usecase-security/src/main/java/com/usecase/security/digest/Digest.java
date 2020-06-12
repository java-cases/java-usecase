package com.usecase.security.digest;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

public class Digest {

    private Digest() {
    }

    public static Optional<String> digest(DigestAlgorithms algorithms, String plainText) {
        return digest(algorithms.getValue(), plainText);
    }

    public static Optional<String> digest(String algorithms, String plainText) {
        Objects.requireNonNull(plainText);

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance(algorithms);
        } catch (NoSuchAlgorithmException e) {
            return Optional.empty();
        }

        byte[] ciphertext = messageDigest.digest(plainText.getBytes());

        return Optional.ofNullable(Hex.encodeHexString(ciphertext));
    }
}
