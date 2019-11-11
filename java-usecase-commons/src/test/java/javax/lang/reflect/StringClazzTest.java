package javax.lang.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class StringClazzTest {

    @Test
    public void getName() {
        Assert.assertEquals(String.class.getName(), StringClazz.getClassName());
    }

    @Test
    public void forName() throws ClassNotFoundException {
        System.out.println(StringClazz.forName().getName());

        Assert.assertEquals(String.class, StringClazz.forName());
    }

    @Test
    public void getTypeClass() {
        Assert.assertEquals(String.class, StringClazz.getTypeClass());
    }

    @Test
    public void getInstanceClass() {
        Assert.assertEquals(String.class, StringClazz.getTypeClass());
    }

    @Test
    public void isInstance() {
        Assert.assertEquals(true, StringClazz.isInstance("test"));

        Assert.assertEquals(false, StringClazz.isInstance(Integer.valueOf(1)));
    }

    @Test
    public void getConstructor() throws NoSuchMethodException {
        Constructor constructor = StringClazz.getConstructorWithArgs();

        System.out.println(constructor);
        Assert.assertEquals(Constructor.class, constructor.getClass());
    }

    @Test
    public void getConstructorWithArgs() throws NoSuchMethodException {
        Constructor constructor = StringClazz.getConstructorWithArgs(String.class);
        System.out.println(constructor);
        Assert.assertEquals(Constructor.class, constructor.getClass());

        constructor = StringClazz.getConstructorWithArgs(StringBuffer.class);
        System.out.println(constructor);
        Assert.assertEquals(Constructor.class, constructor.getClass());

        constructor = StringClazz.getConstructorWithArgs(char[].class);
        System.out.println(constructor);
        Assert.assertEquals(Constructor.class, constructor.getClass());

        constructor = StringClazz.getConstructorWithArgs(byte[].class);
        System.out.println(constructor);
        Assert.assertEquals(Constructor.class, constructor.getClass());
    }

    @Test
    public void newInstance()
            throws InstantiationException, IllegalAccessException {

        Assert.assertEquals(String.class, StringClazz.newInstance().getClass());

        Assert.assertEquals(true, StringClazz.newInstance().isEmpty());
    }

    @Test
    public void newInstanceByConstructor()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Assert.assertEquals(String.class, StringClazz.newInstanceByConstructor().getClass());

        Assert.assertEquals(true, StringClazz.newInstanceByConstructor().isEmpty());
    }

    @Test
    public void newInstanceByConstructorArgs()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Class<?>[] parameterTypes = new Class<?>[]{String.class};
        Assert.assertEquals("test", StringClazz.newInstanceByConstructorArgs(parameterTypes, "test"));
    }

    @Test
    public void getDeclaredMethods() {
        Arrays.stream(StringClazz.getDeclaredMethods())
                .forEach(x -> System.out.println(x.getName() + Arrays.toString(x.getParameterTypes())));
    }

    @Test
    public void getMethods() {
        Arrays.stream(StringClazz.getMethods())
                .forEach(x -> System.out.println(x.getName() + Arrays.toString(x.getParameterTypes())));
    }

    @Test
    public void getMethod()
            throws NoSuchMethodException {

        Method method = StringClazz.getMethod("isEmpty");
        System.out.println(method);
    }

    @Test
    public void getDeclaredFields() {
        Arrays.stream(StringClazz.getDeclaredFields())
                .forEach(x -> System.out.println(x.getName()));
    }

    @Test
    public void getFields() {
        Arrays.stream(StringClazz.getFields())
                .forEach(x -> System.out.println(x.getName()));
    }

    @Test
    public void getField() throws NoSuchFieldException {
        Field field = StringClazz.getField("CASE_INSENSITIVE_ORDER");
        System.out.println(field);
    }


    @Test
    public void invokeMethod()
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        char c = (char) StringClazz.invokeMethod("charAt", int.class, 1);

        Assert.assertEquals('e', c);
    }
}