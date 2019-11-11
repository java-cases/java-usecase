package javax.lang;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringTest {

    @Test
    public void newString() {
        String s1 = new String("abc");
        String s2 = new String("abc");

        Assert.assertEquals(false, s1 == s2);

        Assert.assertEquals(true, s1.equals(s2));

        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void newStringFromString() {
        String s1 = "abc";
        String s2 = new String(s1);

        Assert.assertEquals(false, s1 == s2);

        Assert.assertEquals(true, s1.equals(s2));

        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void stringPool() {
        String s1 = "abc";
        String s2 = "abc";

        Assert.assertEquals(true, s1 == s2);

        Assert.assertEquals(true, s1.equals(s2));

        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void intern() {
        String s1 = "abc";
        String s2 = "abc";

        String s3 = s1.intern();
        String s4 = s2.intern();

        Assert.assertEquals(true, s3 == s4);

        Assert.assertEquals(true, s3.equals(s4));

        Assert.assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    public void newStringWithChars() {
        String s1 = new String(new char[]{'a', 'b', 'c'});
        String s2 = new String(new char[]{'a', 'b', 'c'});

        Assert.assertEquals(false, s1 == s2);

        Assert.assertEquals(true, s1.equals(s2));
    }

    @Test
    public void newStringWithCharsAndIntern() {
        String s1 = new String(new char[]{'a', 'b', 'c'});
        String s2 = new String(new char[]{'a', 'b', 'c'});

        String s3 = s1.intern();
        String s4 = s2.intern();

        Assert.assertEquals(true, s3 == s4);

        Assert.assertEquals(true, s3.equals(s4));
    }

    @Test
    public void newStringWithCharsAndCharset() {
        String s1 = new String(new byte[]{'a', 'b', 'c'}, Charset.forName("UTF-8"));
        String s2 = new String(new byte[]{'a', 'b', 'c'}, Charset.forName("UTF-8"));

        System.out.println(s1);

        Assert.assertEquals(false, s1 == s2);

        Assert.assertEquals(true, s1.equals(s2));
    }

    @Test
    public void equals() {
        String s = "abc";
        StringBuilder builder = new StringBuilder(s);

        Assert.assertEquals(false, s.equals(builder));
    }

    @Test
    public void contentEquals() {
        String s = "abc";
        StringBuilder builder = new StringBuilder(s);

        Assert.assertEquals(true, s.contentEquals(builder));
    }

    @Test
    public void equalsIgnoreCase() {
        String s = "abc";
        Assert.assertTrue(s.equalsIgnoreCase("ABC"));
    }

    @Test
    public void compareTo() {
        String s = "abc";

        Assert.assertTrue(s.compareTo("ABC") > 0);
        Assert.assertTrue(s.compareTo("aBC") > 0);
        Assert.assertTrue(s.compareTo("abC") > 0);

        Assert.assertTrue(s.compareTo("abc") == 0);

        Assert.assertTrue(s.compareTo("abcd") < 0);
    }

    @Test
    public void compareToIgnoreCase() {
        String s = "abc";

        Assert.assertTrue(s.compareToIgnoreCase("ABC") == 0);
        Assert.assertTrue(s.compareToIgnoreCase("aBC") == 0);
        Assert.assertTrue(s.compareToIgnoreCase("abC") == 0);

        Assert.assertTrue(s.compareToIgnoreCase("abc") == 0);

        Assert.assertTrue(s.compareToIgnoreCase("ABCD") < 0);
    }

    @Test
    public void startsWith() {
        String s = "abc";

        Assert.assertTrue(s.startsWith("a"));
        Assert.assertTrue(s.startsWith("ab"));
        Assert.assertTrue(s.startsWith("abc"));

        Assert.assertTrue(s.startsWith(""));

        Assert.assertFalse(s.startsWith("b"));

        Assert.assertFalse(s.startsWith("A"));
    }

    @Test(expected = NullPointerException.class)
    public void startsWithNull() {
        String s = "abc";

        Assert.assertFalse(s.startsWith(null));
    }

    @Test
    public void endsWith() {
        String s = "abc";

        Assert.assertTrue(s.endsWith("c"));
        Assert.assertTrue(s.endsWith("bc"));
        Assert.assertTrue(s.endsWith("abc"));

        Assert.assertTrue(s.endsWith(""));

        Assert.assertFalse(s.endsWith("b"));

        Assert.assertFalse(s.endsWith("C"));
    }

    @Test(expected = NullPointerException.class)
    public void endsWithNull() {
        String s = "abc";

        Assert.assertFalse(s.endsWith(null));
    }

    @Test
    public void hashCodeOfString() {
        System.out.println("a".hashCode());
        System.out.println("ab".hashCode());
        System.out.println("abc".hashCode());

        System.out.println("1".hashCode());
        System.out.println("12".hashCode());
        System.out.println("123".hashCode());
    }

    @Test
    public void indexOf() {
        String s = "abc";

        Assert.assertEquals(0, s.indexOf("a"));
        Assert.assertEquals(1, s.indexOf("b"));

        Assert.assertEquals(-1, s.indexOf("d"));
    }

    @Test
    public void indexOfChar() {
        String s = "abc";

        Assert.assertEquals(0, s.indexOf('a'));
        Assert.assertEquals(1, s.indexOf('b'));

        Assert.assertEquals(-1, s.indexOf('d'));
    }

    @Test(expected = NullPointerException.class)
    public void indexOfNull() {
        String s = "abc";

        Assert.assertEquals(0, s.indexOf(null));
    }

    @Test
    public void indexOfWithFromIndex() {
        String s = "abc";

        Assert.assertEquals(0, s.indexOf("a"));

        Assert.assertEquals(-1, s.indexOf("a", 1));

        Assert.assertEquals(1, s.indexOf("b", 1));
    }

    @Test
    public void indexOfCharWithFromIndex() {
        String s = "abc";

        Assert.assertEquals(0, s.indexOf('a'));

        Assert.assertEquals(-1, s.indexOf('a', 1));

        Assert.assertEquals(1, s.indexOf('b', 1));
    }

    @Test
    public void lastIndexOf() {
        String s = "abac";

        Assert.assertEquals(2, s.lastIndexOf("a"));
        Assert.assertEquals(1, s.lastIndexOf("b"));

        Assert.assertEquals(-1, s.lastIndexOf("d"));
    }

    @Test
    public void lastIndexOfChar() {
        String s = "abac";

        Assert.assertEquals(2, s.lastIndexOf('a'));
        Assert.assertEquals(1, s.lastIndexOf('b'));

        Assert.assertEquals(-1, s.lastIndexOf('d'));
    }

    @Test
    public void lastIndexOfWithFromIndex() {
        String s = "abac";

        Assert.assertEquals(2, s.lastIndexOf("a"));

        Assert.assertEquals(1, s.lastIndexOf("b"));

        Assert.assertEquals(-1, s.lastIndexOf("d"));
    }

    @Test
    public void lastIndexOfCharWithFromIndex() {
        String s = "abac";

        Assert.assertEquals(2, s.lastIndexOf('a'));

        Assert.assertEquals(1, s.lastIndexOf('b'));

        Assert.assertEquals(-1, s.lastIndexOf('d'));
    }

    @Test
    public void substring() {
        String s = "abc";

        Assert.assertEquals("bc", s.substring(1));
    }

    @Test
    public void substringWithBeginEndIndex() {
        String s = "abc";

        Assert.assertEquals("b", s.substring(1, 2));
        Assert.assertEquals("bc", s.substring(1, 3));
    }

    @Test
    public void subSequence() {
        String s = "abc";

        Assert.assertEquals("b", s.subSequence(1, 2));
        Assert.assertEquals("bc", s.subSequence(1, 3));
    }

    @Test
    public void concat() {
        String s = "abc";

        Assert.assertEquals("abcde", s.concat("de"));
    }

    @Test
    public void replaceChar() {
        String s = "abc";

        Assert.assertEquals("a?c", s.replace('b', '?'));
    }

    @Test
    public void matches() {
        String s = "abc";
        Assert.assertEquals(true, s.matches("[a-z]+"));

        Assert.assertEquals(true, "123".matches("\\d+"));
    }

    @Test
    public void contains() {
        String s = "abc";

        Assert.assertEquals(true, s.contains("bc"));
    }

    @Test
    public void replaceFirst() {
        String s = "12ab34";

        Assert.assertEquals("12?34", s.replaceFirst("[a-z]+", "?"));

        Assert.assertEquals("?2ab34", s.replaceFirst("\\w", "?"));
    }

    @Test
    public void replaceAll() {
        String s = "ab12cd";

        Assert.assertEquals("?12?", s.replaceAll("[a-z]+", "?"));

        Assert.assertEquals("??????", s.replaceAll("\\w", "?"));
    }

    @Test
    public void replace() {
        String s = "ab12cd";

        Assert.assertEquals("ab?cd", s.replace("12", "?"));
    }

    @Test
    public void split() {
        String s = "ab12cd34";

        String[] parts = s.split("\\d+");

        Assert.assertEquals(2, parts.length);
        Assert.assertEquals("ab", parts[0]);
        Assert.assertEquals("cd", parts[1]);
    }

    @Test
    public void splitLimit() {
        String s = "ab12cd34ef";

        String[] parts = s.split("\\d+", 2);

        Assert.assertEquals(2, parts.length);
        Assert.assertEquals("ab", parts[0]);
        Assert.assertEquals("cd34ef", parts[1]);
    }

    @Test
    public void join() {
        String s = String.join(";", "s1", "s2", "s3");

        Assert.assertEquals("s1;s2;s3", s);
    }

    @Test
    public void joinWithArray() {
        String[] arr = new String[]{"s1", "s2", "s3"};
        String s = String.join(";", arr);

        Assert.assertEquals("s1;s2;s3", s);
    }

    @Test
    public void joinWithList() {
        List<String> list = Arrays.asList("s1", "s2", "s3");
        String s = String.join(";", list);

        Assert.assertEquals("s1;s2;s3", s);
    }

    @Test
    public void joinWithSet() {
        Set<String> set = new TreeSet<>(Arrays.asList("s1", "s2", "s3"));
        String s = String.join(";", set);

        Assert.assertEquals("s1;s2;s3", s);
    }
}