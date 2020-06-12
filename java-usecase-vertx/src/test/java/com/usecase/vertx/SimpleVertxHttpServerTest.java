package com.usecase.vertx;

import com.usecase.vertx.http.SimpleVertxHttpServer;
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
public class SimpleVertxHttpServerTest {

    private Vertx vertx;

    @Before
    public void setUp(TestContext context) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(SimpleVertxHttpServer.class.getName(), context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void start(TestContext context) {
        final Async async = context.async();

        Handler<Buffer> bufferHandler = body -> {
            context.assertTrue(body.toString().contains("Hello"));
            async.complete();
        };

        Handler<HttpClientResponse> responseHandler = response -> response.handler(bufferHandler);

        int port = 8080;
        vertx.createHttpClient().getNow(port, "localhost", "/", responseHandler);
    }
}