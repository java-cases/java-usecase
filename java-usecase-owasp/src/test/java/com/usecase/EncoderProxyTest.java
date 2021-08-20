package com.usecase;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

public class EncoderProxyTest {

    SecureEncoder encoder = new EncoderDelegate();


    private String getJS() {
        return "<a href='test js'></a> <script> alert(); </script>";
    }


    @Test
    public void canonicalize() {
        encoder.canonicalize("");
    }

    @Test
    public void encodeForHTML() {
        String input = encoder.encodeForHTML(getJS());
        System.out.println(input);

        assertThat(input, Matchers.not(Matchers.containsString("<")));
    }

    @Test
    public void decodeForHTML() {
        String input = encoder.decodeForHTML(encoder.encodeForHTML(getJS()));
        System.out.println(input);

        assertThat(input, Matchers.containsString("<"));
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
        return "http://google.com/openapi/v1/ rds?id=xxx标识";
    }

    @Test
    public void encodeForURL() {
        System.out.println(this.getUrl());
        Optional<String> encoded = encoder.encodeForURL(this.getUrl());
        System.out.println(encoded.get());

        assertThat(encoded.isPresent(), Matchers.is(true));

    }

    @Test
    public void decodeFromURL() {
        Optional<String> encoded = encoder.encodeForURL(this.getUrl());
        System.out.println(encoded.get());

        Optional<String> decoded = encoder.decodeFromURL(encoded.orElse(""));
        System.out.println(decoded.get());

        assertThat(decoded.isPresent(), Matchers.is(true));

    }

    @Test
    public void encodeForMySQL() {
        String username = encoder.encodeForMySQL("user1' or '1'='1");
        String password = encoder.encodeForMySQL("password1''");

        String sql = "select name from user where username='" + username + "' and password ='" + password + "'";
        System.out.println(sql);


        assertThat(username, Matchers.containsString("\\"));
        assertThat(password, Matchers.is("password1''"));
    }

    @Test
    public void encodeForOracleSQL() {
        String username = encoder.encodeForOracleSQL("user1' or '1'='1");
        String password = encoder.encodeForOracleSQL("password1''");

        String sql = "select name from user where username='" + username + "' and password ='" + password + "'";
        System.out.println(sql);

        assertThat(username, Matchers.containsString("\\"));
        assertThat(password, Matchers.is("password1''"));
    }
}