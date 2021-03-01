package com.usecase;

import com.usecase.config.DBSourceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

import javax.net.ssl.HttpsURLConnection;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableRetry
@EnableConfigurationProperties({DBSourceConfig.class})
public class Application {
    public static void main(String[] args) {

        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);

        new SpringApplicationBuilder(Application.class).run(args);
    }
}
