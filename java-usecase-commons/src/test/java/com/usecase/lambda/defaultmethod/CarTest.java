package com.usecase.lambda.defaultmethod;

import org.junit.Test;

public class CarTest {

    @Test
    public void me() {
        Car car=new Car();
        car.me();
    }

    @Test
    public void start() {
        Car car=new Car();
        car.start();
    }
}