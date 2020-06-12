package com.usecase.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringClazz {

    public static String getClassName() {
        return String.class.getName();
    }

    public static Class<?> forName() throws ClassNotFoundException {
        return Class.forName("java.lang.String");
    }

    public static Class<?> getTypeClass() {
        return String.class;
    }

    public static Class<?> getInstanceClass() {
        return "".getClass();
    }

    public static boolean isInstance(Object obj) {
        Class<?> clazz = String.class;

        //判断是否是某个类实例，使用Class类中的 isInstance()方法
        return clazz.isInstance(obj);
    }

    public static String newInstance()
            throws IllegalAccessException, InstantiationException {

        Class<?> clazz = String.class;

        //使用Class对象的newInstance()方法来创建Class对象对应类的实例。
        return (String) clazz.newInstance();
    }

    public static Constructor getConstructor() throws NoSuchMethodException {

        Class<?> clazz = String.class;

        //获取String构造函数 String()
        return clazz.getConstructor();
    }

    public static Constructor getConstructorWithArgs(Class<?>... parameterTypes) throws NoSuchMethodException {

        Class<?> clazz = String.class;

        //获取String构造函数 String()
        return clazz.getConstructor(parameterTypes);
    }

    public static String newInstanceByConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = String.class;

        //获取String构造函数 String()
        Constructor constructor = clazz.getConstructor();
        return (String) constructor.newInstance();
    }

    public static String newInstanceByConstructorArgs(Class<?>[] parameterTypes, Object... initargs)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = String.class;

        //获取String构造函数 String(String str)
        Constructor constructor = clazz.getConstructor(parameterTypes);
        return (String) constructor.newInstance(initargs);
    }

    public static Method[] getDeclaredMethods() {

        Class<?> clazz = String.class;

        //返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        return clazz.getDeclaredMethods();
    }

    public static Method[] getMethods() {

        Class<?> clazz = String.class;

        //返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        return clazz.getMethods();
    }

    public static Method getMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException {

        Class<?> clazz = String.class;

        //返回一个特定的方法，其中第一个参数为方法名称，后面的参数为方法的参数对应Class的对象
        return clazz.getMethod(name, parameterTypes);
    }

    public static Field[] getDeclaredFields() {

        Class<?> clazz = String.class;

        //访问公有的成员变量。
        return clazz.getDeclaredFields();
    }

    public static Field[] getFields() {

        Class<?> clazz = String.class;

        //返所有已声明的成员变量。但不能得到其父类的成员变量。
        return clazz.getFields();
    }

    public static Field getField(String name) throws NoSuchFieldException {

        Class<?> clazz = String.class;

        //返所有已声明的成员变量。但不能得到其父类的成员变量。
        return clazz.getField(name);
    }

    public static Object invokeMethod(String name, Class<?> parameterType, Object parameter) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> clazz = String.class;

        Constructor constructor = clazz.getConstructor(String.class);
        Object obj = constructor.newInstance("test");

        Method method = clazz.getMethod(name, parameterType);

        return method.invoke(obj, parameter);
    }

}
