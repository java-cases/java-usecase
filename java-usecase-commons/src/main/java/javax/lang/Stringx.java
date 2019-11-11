package javax.lang;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Stringx {

    public static String newString(String original) {
        return original;
    }

    public static String newString(char[] value) {
        return new String(value);
    }

    public static String newString(char[] value, int offset, int count) {
        return new String(value, offset, count);
    }

    public static String newString(byte[] bytes, int offset, int length, String charsetName)
            throws UnsupportedEncodingException {

        return new String(bytes, offset, length, charsetName);
    }

    public static String newString(byte[] bytes, int offset, int length, Charset charset) {
        return new String(bytes, offset, length, charset);
    }

    public static String newString(byte[] bytes, String charsetName)
            throws UnsupportedEncodingException {

        return new String(bytes, charsetName);
    }

    public static String newString(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    public static String newString(byte[] bytes) {
        return new String(bytes,Charset.forName("UTF-8"));
    }

    public static String newString(StringBuffer buffer) {
        return new String(buffer);
    }

    public static String newString(StringBuilder builder) {
        return new String(builder);
    }

}
