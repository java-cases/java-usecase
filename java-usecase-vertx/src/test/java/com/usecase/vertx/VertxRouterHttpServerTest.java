package com.usecase.vertx;

import com.usecase.vertx.http.routerbuilder.VertxRouterHttpServer;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class VertxRouterHttpServerTest {

    private Vertx vertx;
    private int port=8080;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(VertxRouterHttpServer.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void get(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            System.out.println(body.toString());
            context.assertTrue(body.toString().contains("get"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/get", responseHandler);
    }

    @Test
    public void index(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            context.assertTrue(body.toString().contains("index"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/index", responseHandler);
    }

    @Test
    public void order(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            context.assertTrue(body.toString().contains("*"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/index/*", responseHandler);
    }

    @Test
    public void orderMain(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            context.assertTrue(body.toString().contains("main"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/index/main", responseHandler);
    }

}