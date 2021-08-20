package com.usecase;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

        new SpringApplicationBuilder(Application.class).run(args);
    }
}
