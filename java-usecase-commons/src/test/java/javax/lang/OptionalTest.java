package javax.lang;

import javax.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void empty() {
        Optional<String> optional = Optional.empty();
        Assert.assertFalse(optional.isPresent());

        Optional<Integer> optionalInteger = Optional.empty();
        Assert.assertFalse(optionalInteger.isPresent());
    }

    @Test
    public void of() {
        Optional<Integer> optional = Optional.of(1);

        Assert.assertTrue(optional.isPresent());
        Assert.assertTrue(optional.get() == 1);
    }

    @Test(expected = NullPointerException.class)
    public void ofWithNull() {
        Optional.of(null);
    }

    @Test
    public void ofNullable() {
        Optional<Integer> optional = Optional.ofNullable(1);
        Assert.assertTrue(optional.isPresent());
        Assert.assertTrue(optional.get() == 1);
    }

    @Test(expected = NoSuchElementException.class)
    public void ofNullableWithNull() {
        Optional<Integer> optional = Optional.ofNullable(null);
        Assert.assertFalse(optional.isPresent());

        optional.get();
    }

    @Test
    public void ifPresent() {
        Optional<String> optional = Optional.ofNullable("ifPresent");
        optional.ifPresent(x -> System.out.println(x));

        optional = Optional.ofNullable(null);
        optional.ifPresent(x -> System.out.println(x));
    }

    @Test
    public void orElse() {
        //如果对象中存在一个值，则返回它，否则返回传入的“默认参数”
        String result = Optional.ofNullable("ifPresent").orElse("default");
        Assert.assertEquals("ifPresent", result);

        String data = null;
        result = Optional.ofNullable(data).orElse("default");
        Assert.assertEquals("default", result);
    }

    @Test
    public void orElseGet() {
        String result = Optional.ofNullable("ifPresent").orElseGet(() -> "default");
        Assert.assertEquals("ifPresent", result);

        String data = null;
        result = Optional.ofNullable(data).orElseGet(() -> "default");
        Assert.assertEquals("default", result);
    }

    @Test
    public void orElseThrow() {
        String result = Optional.ofNullable("ifPresent").orElseThrow(() -> new IllegalArgumentException());

        Assert.assertEquals("ifPresent", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void orElseThrowWithNull() {
        String data = null;
        String result = Optional.ofNullable(data).orElseThrow(() -> new IllegalArgumentException());

        Assert.assertEquals("default", result);
    }

    @Test
    public void filter() {
        Optional<Integer> optional = Optional.ofNullable(1);

        Assert.assertTrue(optional.filter(x -> x == 1).isPresent());
        Assert.assertFalse(optional.filter(x -> x > 1).isPresent());
    }

    @Test
    public void filterString() {
        String data = " password ";
        Optional<String> optional = Optional.of(data);

        boolean result = optional
                .map(x -> x.trim())
                .filter(x -> x.equals("password"))
                .isPresent();

        Assert.assertEquals(true, result);
    }

    @Test
    public void map() {
        Employee data = new Employee(5);

        Optional<Integer> optional = Optional.ofNullable(data)
                .map(Employee::getNumber)
                .filter(x -> x >= 0)
                .filter(x -> x <= 10);

        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(true, optional.get() == 5);
    }

    @Test
    public void mapInteger() {
        String data = "1";
        Optional<Integer> optional = Optional.ofNullable(data)
                .map(Integer::new)
                .filter(x -> x >= 0)
                .filter(x -> x <= 10);

        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(true, optional.get() == 1);
    }

    @Test
    public void mapList() {
        List<String> companyNames = Arrays.asList("", "microsoft", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int count = listOptional
                .map(List::size)
                .orElse(0);

        Assert.assertEquals(3, count);
    }

    @Test
    public void mapWithNull() {
        String data = null;
        boolean result = Optional.ofNullable(data)
                .map(Integer::new)
                .filter(x -> x >= 0)
                .filter(x -> x <= 10)
                .isPresent();

        Assert.assertFalse(result);
    }

    @Test
    public void flatMap() {
        Employee data = new Employee(5);

        Optional<Integer> optional = Optional.ofNullable(data)
                .flatMap(e -> Optional.ofNullable(e.getNumber()))
                .filter(x -> x >= 0)
                .filter(x -> x <= 10);

        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(true, optional.get() == 5);
    }
}