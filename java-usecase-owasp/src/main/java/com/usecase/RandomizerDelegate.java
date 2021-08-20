package com.usecase;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Randomizer;
import org.owasp.esapi.errors.EncryptionException;

import java.util.Optional;

public class RandomizerDelegate implements SecureRandomizer {

    private Randomizer randomizer = ESAPI.randomizer();

    @Override
    public String getRandomString(int length, char[] characterSet) {
        return randomizer.getRandomString(length, characterSet);
    }

    @Override
    public boolean getRandomBoolean() {
        return randomizer.getRandomBoolean();
    }

    @Override
    public int getRandomInteger(int min, int max) {
        return randomizer.getRandomInteger(min, max);
    }

    @Override
    public long getRandomLong() {
        return randomizer.getRandomLong();
    }

    @Override
    public String getRandomFilename(String extension) {
        return randomizer.getRandomFilename(extension);
    }

    @Override
    public float getRandomReal(float min, float max) {
        return randomizer.getRandomReal(min, max);
    }

    @Override
    public Optional<String> getRandomGUID() {
        try {
            return Optional.ofNullable(randomizer.getRandomGUID());
        } catch (EncryptionException e) {
            return Optional.empty();
        }
    }

    @Override
    public byte[] getRandomBytes(int n) {
        return randomizer.getRandomBytes(n);
    }
}
