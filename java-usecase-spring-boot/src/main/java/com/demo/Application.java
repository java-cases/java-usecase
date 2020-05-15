package com.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRetry
class WebApplication {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession ) -> true);

        new SpringApplicationBuilder(WebApplication.class).run(args);
    }
}
