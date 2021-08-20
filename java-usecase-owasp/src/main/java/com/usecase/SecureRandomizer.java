package com.usecase;

import java.util.Optional;

public interface SecureRandomizer {
    String getRandomString(int length, char[] characterSet);

    boolean getRandomBoolean();

    int getRandomInteger(int min, int max);

    long getRandomLong();

    String getRandomFilename(String extension);

    float getRandomReal(float min, float max);

    Optional<String> getRandomGUID();

    byte[] getRandomBytes(int n);
}
