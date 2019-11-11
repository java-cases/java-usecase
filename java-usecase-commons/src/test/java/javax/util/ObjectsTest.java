package javax.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class ObjectsTest {

    @Test
    public void equals() {

        assertTrue(Objects.equals(null, null));
        assertFalse(Objects.equals(null, "a"));
        assertFalse(Objects.equals("a", null));

        assertTrue(Objects.equals("a", "a"));

        boolean r = Objects.equals(Integer.valueOf(1), Integer.valueOf(1));
        assertTrue(r);

        r = Objects.equals(new Integer(1), new Integer(1));
        assertTrue(r);

        r = Objects.equals(new ArrayList(), new ArrayList());
        assertTrue(r);

        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(1);
        list2.add(1);

        r = Objects.equals(list1, list1);
        assertTrue(r);

        r = Objects.equals(list1, list2);
        assertTrue(r);

        r = Objects.equals(Arrays.asList(1), Arrays.asList(1));
        assertTrue(r);
    }

    @Test
    public void deepEquals() {

        assertTrue(Objects.deepEquals(null, null));
        assertFalse(Objects.deepEquals(null, "a"));
        assertFalse(Objects.deepEquals("a", null));

        assertTrue(Objects.deepEquals("a", "a"));

        boolean r = Objects.deepEquals(Integer.valueOf(1), Integer.valueOf(1));
        assertTrue(r);

        r = Objects.deepEquals(new Integer(1), new Integer(1));
        assertTrue(r);

        r = Objects.deepEquals(new ArrayList(), new ArrayList());
        assertTrue(r);

        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(1);
        list2.add(1);

        r = Objects.deepEquals(list1, list1);
        assertTrue(r);

        r = Objects.deepEquals(list1, list2);
        assertTrue(r);

        r = Objects.deepEquals(Arrays.asList(1), Arrays.asList(1));
        assertTrue(r);
    }

    @Test
    public void hashCodeOfObjects() {
        assertEquals(1, Objects.hashCode(new Integer(1)));

        assertEquals(1, Objects.hashCode(1));
        assertEquals(2, Objects.hashCode(2));
        assertEquals(3, Objects.hashCode(3));

        assertEquals(48, Objects.hashCode("0"));
        assertEquals(49, Objects.hashCode("1"));

        assertEquals(97, Objects.hashCode("a"));
        assertEquals(122, Objects.hashCode("z"));

        assertEquals(65, Objects.hashCode("A"));
        assertEquals(90, Objects.hashCode("Z"));

        assertEquals(0, Objects.hashCode(null));
    }

    @Test
    public void hashOfObjects() {
        assertEquals(32, Objects.hash(new Integer(1)));

        assertEquals(30817, Objects.hash(1, 2, 3));

        assertEquals(0, Objects.hash(null));
    }

    @Test
    public void toStringOfObjects() {
        assertTrue(Objects.toString(new int[]{1, 2, 3}).startsWith("[I"));

        assertEquals("1", Objects.toString(1));
        assertEquals("1", Objects.toString(new Integer(1)));

        assertEquals("null", Objects.toString(null));
    }

    @Test
    public void compare() {
        assertEquals(0, Objects.compare(1, 1, (x, y) -> x - y));
        assertEquals(-2, Objects.compare(1, 3, (x, y) -> x - y));
        assertEquals(2, Objects.compare(3, 1, (x, y) -> x - y));

        assertEquals(0, Objects.compare(new Integer(1), new Integer(1), (x, y) -> x - y));
        assertEquals(-2, Objects.compare(new Integer(1), new Integer(3), (x, y) -> x - y));
        assertEquals(2, Objects.compare(new Integer(3), new Integer(1), (x, y) -> x - y));

        assertEquals(0, Objects.compare(1, 1, null));

    }

    @Test(expected = NullPointerException.class)
    public void compareWithNullComparator() {
        assertEquals(0, Objects.compare(1, 2, null));
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNull() {
        Objects.requireNonNull(1);

        Objects.requireNonNull(null);
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNullWithMessage() {
        Objects.requireNonNull(1, "NullPointerException");

        Objects.requireNonNull(null, "NullPointerException");
    }

    @Test(expected = NullPointerException.class)
    public void requireNonNullWithMessageSupplier() {
        Supplier<String> messageSupplier = () -> "NullPointerException";

        Objects.requireNonNull(1, messageSupplier);

        Objects.requireNonNull(null, messageSupplier);
    }
}
