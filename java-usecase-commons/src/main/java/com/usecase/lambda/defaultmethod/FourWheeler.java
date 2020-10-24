package com.usecase.lambda.defaultmethod;

public interface FourWheeler {

    // 静态方法
    static void move() {
        System.out.println("FourWheeler.move");
    }

    //默认方法
    default void me() {
        System.out.println("FourWheeler");
    }
}
