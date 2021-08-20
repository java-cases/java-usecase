package com.usecase.vertx;

import com.usecase.vertx.http.VertxHttpServer;
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
public class VertxHttpServerTest {

    private Vertx vertx;
    private int port = 8080;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(VertxHttpServer.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void getByPathParam(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            System.out.println(body.toString());
            context.assertTrue(body.toString().equals("get:1"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/products/1", responseHandler);
    }


    @Test()
    public void deleteByPathParam(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            System.out.println(body.toString());
            context.assertTrue(body.toString().contains("1"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().delete(port, "localhost", "/products/1", responseHandler);
    }


    @Test
    public void getByQueryParam(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            System.out.println(body.toString());
            context.assertTrue(body.toString().contains("action=get"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        vertx.createHttpClient().getNow(port, "localhost", "/actions?action=get&id=1",
                responseHandler);
    }

}