package com.usecase.lang;

public class Characterx {

    public static Character newCharacter(char value) {
        return new Character(value);
    }

    public static Character valueOf(char c) {
        if (c <= 127) { // must cache
            return CharacterCache.cache[(int) c];
        }
        return new Character(c);
    }

    private static class CharacterCache {
        private CharacterCache() {
        }

        static final Character[] cache = new Character[127 + 1];

        static {
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new Character((char) i);
            }
        }
    }

    public static int hashCode(char value) {
        return (int) value;
    }

    //判断给定的字符是否是大写字符
    public static boolean isUpperCase(char ch) {
        return Character.isUpperCase(ch);
    }

    public static boolean isUpperCase(int codePoint) {
        return Character.isUpperCase(codePoint);
    }

    //判断给定的字符是否是小写字符
    public static boolean isLowerCase(char ch) {
        return Character.isLowerCase(ch);
    }

    public static boolean isLowerCase(int codePoint) {
        return Character.isLowerCase(codePoint);
    }

    //标题字符
    public static boolean isTitleCase(char ch) {
        return isTitleCase((int) ch);
    }

    public static boolean isTitleCase(int codePoint) {
        return Character.isTitleCase(codePoint);
    }

    //判断给定的字符是否是数字字符
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    public static boolean isDigit(int codePoint) {
        return Character.isDigit(codePoint);
    }

    //字符是否在unicode范围
    public static boolean isDefined(char ch) {
        return isDefined((int)ch);
    }

    public static boolean isDefined(int codePoint) {
        return Character.isDefined(codePoint);
    }

    public static boolean isLetter(char ch) {
        return isLetter((int) ch);
    }

    public static boolean isLetter(int codePoint) {
        return Character.isLetter(codePoint);
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetterOrDigit((int) ch);
    }

    public static boolean isLetterOrDigit(int codePoint) {
        return Character.isLetterOrDigit(codePoint);
    }

    public static boolean isJavaIdentifierStart(char ch) {
        return isJavaIdentifierStart((int) ch);
    }

    public static boolean isJavaIdentifierStart(int codePoint) {
        return Character.isJavaIdentifierStart(codePoint);
    }

    public static boolean isJavaIdentifierPart(char ch) {
        return isJavaIdentifierPart((int) ch);
    }

    public static boolean isJavaIdentifierPart(int codePoint) {
        return Character.isJavaIdentifierPart(codePoint);
    }

    //把给定的字符转换为大写字符
    public static char toUpperCase(char ch) {
        return Character.toUpperCase(ch);
    }

    public static int toUpperCase(int codePoint) {
        return Character.toUpperCase(codePoint);
    }

    //把给定的字符转换为小写字符
    public static char toLowerCase(char ch) {
        return Character.toLowerCase(ch);
    }

    public static int toLowerCase(int codePoint) {
        return Character.toLowerCase(codePoint);
    }

    public static char toTitleCase(char ch) {
        return (char) toTitleCase((int) ch);
    }

    public static int toTitleCase(int codePoint) {
        return Character.toTitleCase(codePoint);
    }

    public static int digit(char ch, int radix) {
        return digit((int) ch, radix);
    }

    public static int digit(int codePoint, int radix) {
        return Character.digit(codePoint, radix);
    }

    public static int getNumericValue(char ch) {
        return getNumericValue((int) ch);
    }

    public static int getNumericValue(int codePoint) {
        return Character.getNumericValue(codePoint);
    }

    public static boolean isSpaceChar(char ch) {
        return isSpaceChar((int) ch);
    }

    public static boolean isSpaceChar(int codePoint) {
        return Character.isSpaceChar(codePoint);
    }

    public static boolean isWhitespace(char ch) {
        return isWhitespace((int) ch);
    }

    public static boolean isWhitespace(int codePoint) {
        return Character.isWhitespace(codePoint);
    }

    public static int compare(char x, char y) {
        return x - y;
    }

    public static String getName(int codePoint) {
        return Character.getName(codePoint);
    }
}
