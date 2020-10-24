package com.usecase.lambda.defaultmethod;

public interface Vehicle {

    // 静态方法
    static void blowHorn() {
        System.out.println("Vehicle.blowHorn");
    }

    //默认方法
    default void me() {
        System.out.println("Vehicle");
    }
}
