package com.usecase;

import org.owasp.esapi.crypto.CipherText;
import org.owasp.esapi.crypto.PlainText;
import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.errors.IntegrityException;

import javax.crypto.SecretKey;

public interface SecureEncryptor {
    String hash(String plaintext, String salt) throws EncryptionException;

    String hash(String plaintext, String salt, int iterations) throws EncryptionException;

    CipherText encrypt(PlainText plaintext) throws EncryptionException;

    CipherText encrypt(SecretKey key, PlainText plaintext) throws EncryptionException;

    PlainText decrypt(CipherText ciphertext) throws EncryptionException;

    PlainText decrypt(SecretKey key, CipherText ciphertext) throws EncryptionException;

    String sign(String data) throws EncryptionException;

    boolean verifySignature(String signature, String data);

    String seal(String data, long timestamp) throws IntegrityException;

    String unseal(String seal) throws EncryptionException;

    boolean verifySeal(String seal);

    long getRelativeTimeStamp(long offset);

    long getTimeStamp();
}
