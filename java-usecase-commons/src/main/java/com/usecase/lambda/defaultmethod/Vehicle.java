package com.usecase.lambda.defaultmethod;

public interface Vehicle {

    //默认方法
    default void me() {
        System.out.println("Vehicle");
    }

    // 静态方法
    static void blowHorn(){
        System.out.println("Vehicle.blowHorn");
    }
}
