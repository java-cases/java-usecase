package com.usecase.lambda;

import java.beans.PropertyChangeListener;
import java.io.FileFilter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.PathMatcher;
import java.security.PrivilegedAction;
import java.util.Comparator;
import java.util.concurrent.Callable;

public class BuildinActions {

    public static Runnable runnable() {
        return () -> System.out.println("Runnable");
    }

    public static Callable callable() {
        return () -> "Runnable";
    }

    public static Comparator<Integer> comparator() {
        return (x, y) -> x.compareTo(y);
    }

    public static FileFilter fileFilter() {
        return file -> file.canRead();
    }

    public static PathMatcher pathMatcher() {
        return path -> path.getFileName().endsWith(".exe");
    }

    public static InvocationHandler invocationHandler() {
        return (Object proxy, Method method, Object[] args) -> method.getDefaultValue();
    }

    public static PropertyChangeListener propertyChangeListener() {
        return event -> System.out.println(event.getNewValue());
    }

    public static PrivilegedAction privilegedAction() {
        return () -> null;
    }
}
