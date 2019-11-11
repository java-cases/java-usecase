package javax.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class PatternTest {

    @Test
    public void compile() {
        //简单工厂方法创建一个正则表达式
        Pattern p = Pattern.compile("\\w+");

        assertNotNull(p);
    }

    @Test
    public void pattern() {
        //返回正则表达式的字符串形式
        Pattern p = Pattern.compile("\\w+");

        assertEquals("\\w+", p.pattern());
    }

    @Test
    public void matches() {
        //快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.
        Boolean r = Pattern.matches("\\d+", "11");
        assertTrue(r);

        r = Pattern.matches("\\d+", "11aa");
        assertFalse(r);

        r = Pattern.matches("\\d+", "11aa11");
        assertFalse(r);
    }

    @Test
    public void split() {
        Pattern p = Pattern.compile("\\d+");
        String[] items = p.split("account1tel2mail:tom@qq.com");

        System.out.println(Arrays.toString(items));

        assertEquals(3, items.length);

        assertEquals("account", items[0]);
        assertEquals("tel", items[1]);
        assertEquals("mail:tom@qq.com", items[2]);

    }

    @Test
    public void matcher() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        assertEquals(p, m.pattern());
    }
}
