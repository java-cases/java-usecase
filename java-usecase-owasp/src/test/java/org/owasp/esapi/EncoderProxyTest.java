package org.owasp.esapi;

import org.junit.Assert;
import org.junit.Test;
import org.owasp.SecureEncoder;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class EncoderProxyTest {

    SecureEncoder encoder = new EncoderDelegate();


    private String getJS() {
        return "<a href='sdfs'></a> < script > alert(); </ script >";
    }


    @Test
    public void canonicalize() {
        encoder.canonicalize("");
    }

    @Test
    public void encodeForHTML() {
        String input = encoder.encodeForHTML(getJS());
        System.out.println(input);

        Assert.assertFalse(input.contains("<"));
    }

    @Test
    public void decodeForHTML() {
        String input = encoder.decodeForHTML(encoder.encodeForHTML(getJS()));
        System.out.println(input);

        assertTrue(input.contains("<"));
    }

    @Test
    public void encodeForCSS() {
    }


    @Test
    public void encodeForHTMLAttribute() {
    }

    @Test
    public void encodeForJavaScript() {
    }

    @Test
    public void encodeForVBScript() {
    }

    private String getUrl() {
        return "http://google.com/openapi/v1/ rds";
    }

    @Test
    public void encodeForURL() {
        Optional<String> r = encoder.encodeForURL(this.getUrl());

        assertTrue(r.isPresent());
        System.out.println(r.get());
    }

    @Test
    public void decodeFromURL() {
        Optional<String> r = encoder.decodeFromURL(encoder.encodeForURL(this.getUrl()).orElse(""));

        assertTrue(r.isPresent());
        System.out.println(r.get());
    }

    @Test
    public void encodeForMySQL() {
        String username = encoder.encodeForMySQL("user1' or '1'='1");
        String password = encoder.encodeForMySQL("password1''");

        String sql = "select name from user where username='" + username + "' and password ='" + password + "'";
        System.out.println(sql);

        assertTrue(username.contains("\'"));
        Assert.assertFalse(password.equals("password1''"));
    }

    @Test
    public void encodeForOracleSQL() {
        String username = encoder.encodeForOracleSQL("user1' or '1'='1");
        String password = encoder.encodeForOracleSQL("password1''");

        String sql = "select name from user where username='" + username + "' and password ='" + password + "'";
        System.out.println(sql);

        assertTrue(username.contains("\'"));
        Assert.assertFalse(password.equals("password1''"));
    }
}