package javax.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class MatcherTest {

    @Test
    public void matches() {
        Pattern p = Pattern.compile("\\d+");

        //对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        Boolean r = p.matcher("11aa").matches();
        assertFalse(r);

        r = p.matcher("11").matches();
        assertTrue(r);
    }

    @Test
    public void matchesChain() {
        //对整个字符串进行匹配,只有整个字符串都匹配了才返回true
        Boolean r = Pattern.compile("\\d+").matcher("11aa").matches();
        assertFalse(r);

        r = Pattern.compile("\\d+").matcher("11").matches();
        assertTrue(r);
    }

    @Test
    public void lookingAt() {
        //对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true
        Boolean r = Pattern.compile("\\d+").matcher("11").lookingAt();
        assertTrue(r);

        r = Pattern.compile("\\d+").matcher("11aa").lookingAt();
        assertTrue(r);

        r = Pattern.compile("\\d+").matcher("aa11").lookingAt();
        assertFalse(r);
    }

    @Test
    public void find() {
        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = Pattern.compile("\\d+").matcher("11").find();
        assertTrue(r);

        r = Pattern.compile("\\d+").matcher("11aa").find();
        assertTrue(r);

        r = Pattern.compile("\\d+").matcher("aa11").find();
        assertTrue(r);
    }

    @Test
    public void findMultiTimes() {
        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        assertEquals("11", m.group());
        assertEquals(0, m.start());
        assertEquals(2, m.end());

        r = m.find();
        assertTrue(r);

        assertEquals("11", m.group());
        assertEquals(4, m.start());
        assertEquals(6, m.end());
    }


    @Test
    public void findLoop() {
        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        while (m.find()) {
            System.out.println("group: " + m.group());
            System.out.println("start: " + m.start());
            System.out.println("end: " + m.end());
        }
    }

    @Test
    public void startOfLookingAt() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true.
        Boolean r = m.lookingAt();
        assertTrue(r);

        //返回匹配到的子字符串在字符串中的索引位置.
        int startIndex = m.start();

        assertEquals(0, startIndex);
    }

    @Test
    public void start() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串在字符串中的索引位置.
        int startIndex = m.start();

        assertEquals(2, startIndex);
    }

    @Test
    public void endOfLookingAt() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true.
        Boolean r = m.lookingAt();
        assertTrue(r);

        //返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
        int endIndex = m.end();

        assertEquals(2, endIndex);
    }

    @Test
    public void end() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
        int endIndex = m.end();

        assertEquals(2, endIndex);
    }


    @Test
    public void groupCount() {
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("11aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串.
        assertEquals(2, m.groupCount());
    }

    @Test
    public void group() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("11aa11");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串.
        assertEquals("11", m.group());
    }

    @Test
    public void groups() {
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("11aa22bb");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串.
        assertEquals(2, m.groupCount());

        assertEquals("aa", m.group(1));
        assertEquals(2, m.start(1));
        assertEquals(4, m.end(1));

        assertEquals("22", m.group(2));
        assertEquals(4, m.start(2));
        assertEquals(6, m.end(2));
    }

    @Test
    public void groupsMultiTimes() {
        Pattern p = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m = p.matcher("aa11bb22");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串.
        assertEquals(2, m.groupCount());
        assertEquals("aa", m.group(1));
        assertEquals("11", m.group(2));

        r = m.find();
        assertTrue(r);

        //返回匹配到的子字符串.
        assertEquals(2, m.groupCount());
        assertEquals("bb", m.group(1));
        assertEquals("22", m.group(2));
    }

    @Test
    public void replaceFirst() {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher matcher = p.matcher("aa11bb22");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = matcher.find();
        assertTrue(r);

        String replacement = "?";
        String newText = matcher.replaceFirst(Matcher.quoteReplacement(replacement));

        System.out.println(newText);
        assertEquals("aa?bb22", newText);
    }

    @Test
    public void replaceAll() {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher matcher = p.matcher("aa11bb22");

        //对字符串进行匹配,匹配到的字符串可以在任何位置.
        Boolean r = matcher.find();
        assertTrue(r);

        String replacement = "?";
        String newText = matcher.replaceAll(Matcher.quoteReplacement(replacement));

        System.out.println(newText);
        assertEquals("aa?bb?", newText);
    }

    @Test
    public void replaceAllChain() {
        String replacement = "?";
        String newText = Pattern.compile("(\\d+)")
                .matcher("aa11bb22")
                .replaceAll(Matcher.quoteReplacement(replacement));

        System.out.println(newText);
        assertEquals("aa?bb?", newText);
    }
}
