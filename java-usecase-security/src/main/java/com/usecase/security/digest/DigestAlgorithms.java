package com.usecase.security.digest;

public enum DigestAlgorithms {

    MD2("MD2"),
    MD5("MD5"),
    SHA_1("SHA-1"),
    SHA_224("SHA-224"),
    SHA_256("SHA-256"),
    SHA_384("SHA-384"),
    SHA_512("SHA-512"),
    SHA3_224("SHA3-224"),
    SHA3_256("SHA3-256"),
    SHA3_384("SHA3-384"),
    SHA3_512("SHA3-512");

    public String getValue() {
        return value;
    }

    private final String value;

    DigestAlgorithms(String value) {
        this.value = value;
    }

}
