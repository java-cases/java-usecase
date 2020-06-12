package com.usecase;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
class WebApplication {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(WebApplication.class).run(args);
    }
}
