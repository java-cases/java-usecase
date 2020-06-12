package com.usecase.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isEmpty() {

        //判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));

        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("   "));
        assertFalse(StringUtils.isEmpty("bob"));
        assertFalse(StringUtils.isEmpty(" bob "));
    }

    @Test
    public void isBlank() {
        //判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank(" "));
        assertTrue(StringUtils.isBlank("        "));
        assertTrue(StringUtils.isBlank("\t"));  //制表符
        assertTrue(StringUtils.isBlank("\t \n \f \r"));  //制表符、换行符、换页符和回车符

        assertFalse(StringUtils.isBlank("\b")); //"/b"为单词边界符
        assertFalse(StringUtils.isBlank("bob"));
        assertFalse(StringUtils.isBlank(" bob "));
    }

    @Test
    public void trim() {
        assertEquals(null, StringUtils.trim(null));
        assertEquals("", StringUtils.trim(""));
        assertEquals("", StringUtils.trim("     "));
        assertEquals("abc", StringUtils.trim("abc"));
        assertEquals("abc", StringUtils.trim("    abc    "));
    }

    @Test
    public void trimToNull() {
        //Removes control characters (char &lt;= 32) from both
        //ends of this String returning null if the String is
        //empty ("") after the trim or if it is null.
        assertEquals(null, StringUtils.trimToNull(null));
        assertEquals(null, StringUtils.trimToNull(""));
        assertEquals(null, StringUtils.trimToNull("     "));

        assertEquals("abc", StringUtils.trimToNull("abc"));
        assertEquals("abc", StringUtils.trimToNull("    abc    "));
    }

    @Test
    public void trimToEmpty() {
        assertEquals("", StringUtils.trimToEmpty(null));
        assertEquals("", StringUtils.trimToEmpty(""));
        assertEquals("", StringUtils.trimToEmpty("     "));

        assertEquals("abc", StringUtils.trimToEmpty("abc"));
        assertEquals("abc", StringUtils.trimToEmpty("    abc    "));
    }

    @Test
    public void strip() {
        assertEquals(null, StringUtils.strip(null));

        assertEquals("", StringUtils.strip(""));
        assertEquals("", StringUtils.strip("   "));

        assertEquals("abc", StringUtils.strip("abc"));
        assertEquals("abc", StringUtils.strip("  abc"));
        assertEquals("abc", StringUtils.strip("abc  "));
        assertEquals("abc", StringUtils.strip(" abc "));

        assertEquals("ab c", StringUtils.strip(" ab c "));
    }

    @Test
    public void stripToNull() {
        assertEquals(null, StringUtils.stripToNull(null));
        assertEquals(null, StringUtils.stripToNull(""));
        assertEquals(null, StringUtils.stripToNull("   "));

        assertEquals("abc", StringUtils.stripToNull("abc"));
        assertEquals("abc", StringUtils.stripToNull("  abc"));
        assertEquals("abc", StringUtils.stripToNull("abc  "));
        assertEquals("abc", StringUtils.stripToNull(" abc "));

        assertEquals("ab c", StringUtils.stripToNull(" ab c "));
    }

    @Test
    public void stripToEmpty() {
        assertEquals("", StringUtils.stripToEmpty(null));
        assertEquals("", StringUtils.stripToEmpty(""));
        assertEquals("", StringUtils.stripToEmpty("   "));

        assertEquals("abc", StringUtils.stripToEmpty("abc"));
        assertEquals("abc", StringUtils.stripToEmpty("  abc"));
        assertEquals("abc", StringUtils.stripToEmpty("abc  "));
        assertEquals("abc", StringUtils.stripToEmpty(" abc "));

        assertEquals("ab c", StringUtils.stripToEmpty(" ab c "));
    }
}
