package com.usecase;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

public class RandomizerProxyTest {

    private SecureRandomizer randomizer = new RandomizerDelegate();

    @Test
    public void getRandomString() {
        String r = randomizer.getRandomString(10, null);

        System.out.println(r);
    }

    @Test
    public void getRandomBoolean() {
        boolean r = randomizer.getRandomBoolean();

        System.out.println(r);
    }

    @Test
    public void getRandomInteger() {
        Integer r = randomizer.getRandomInteger(0, 100);

        System.out.println(r);
    }

    @Test
    public void getRandomLong() {
        Long r = randomizer.getRandomLong();

        System.out.println(r);
    }

    @Test
    public void getRandomFilename() {
        String r = randomizer.getRandomFilename("bin");

        System.out.println(r);
    }

    @Test
    public void getRandomReal() {
        float r = randomizer.getRandomReal(1f, 100f);

        System.out.println(r);
    }

    @Test
    public void getRandomGUID() {
        Optional<String> r = randomizer.getRandomGUID();

        assertThat(r.isPresent(), Matchers.is(true));
        System.out.println(r);
    }

    @Test
    public void getRandomBytes() {
        byte[] r = randomizer.getRandomBytes(100);

        System.out.println(r);
    }
}