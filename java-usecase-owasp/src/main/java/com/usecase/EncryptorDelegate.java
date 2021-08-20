package com.usecase;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encryptor;
import org.owasp.esapi.crypto.CipherText;
import org.owasp.esapi.crypto.PlainText;
import org.owasp.esapi.errors.EncryptionException;
import org.owasp.esapi.errors.IntegrityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;

public class EncryptorDelegate implements SecureEncryptor {

    private static final Logger log = LoggerFactory.getLogger(EncryptorDelegate.class);

    private Encryptor encryptor = ESAPI.encryptor();

    @Override
    public String hash(String plaintext, String salt) throws EncryptionException {
        return encryptor.hash(plaintext, salt);
    }

    @Override
    public String hash(String plaintext, String salt, int iterations) throws EncryptionException {
        return encryptor.hash(plaintext, salt, iterations);
    }

    @Override
    public CipherText encrypt(PlainText plaintext) throws EncryptionException {
        return encryptor.encrypt(plaintext);
    }

    @Override
    public CipherText encrypt(SecretKey key, PlainText plaintext) throws EncryptionException {
        return encryptor.encrypt(key, plaintext);
    }

    @Override
    public PlainText decrypt(CipherText ciphertext) throws EncryptionException {
        return encryptor.decrypt(ciphertext);
    }

    @Override
    public PlainText decrypt(SecretKey key, CipherText ciphertext) throws EncryptionException {
        return encryptor.decrypt(key, ciphertext);
    }

    @Override
    public String sign(String data) throws EncryptionException {
        return encryptor.sign(data);
    }

    @Override
    public boolean verifySignature(String signature, String data) {
        return encryptor.verifySignature(signature, data);
    }

    @Override
    public String seal(String data, long timestamp) throws IntegrityException {
        return encryptor.seal(data, timestamp);
    }

    @Override
    public String unseal(String seal) throws EncryptionException {
        return encryptor.unseal(seal);
    }

    @Override
    public boolean verifySeal(String seal) {
        return encryptor.verifySeal(seal);
    }

    @Override
    public long getRelativeTimeStamp(long offset) {
        return encryptor.getRelativeTimeStamp(offset);
    }

    @Override
    public long getTimeStamp() {
        return encryptor.getTimeStamp();
    }
}
