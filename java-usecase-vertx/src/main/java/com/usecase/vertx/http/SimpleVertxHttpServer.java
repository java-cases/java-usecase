package com.usecase.vertx.http;

import io.vertx.core.AbstractVerticle;

public class SimpleVertxHttpServer extends AbstractVerticle {

    @Override
    public void start()  {

        vertx.createHttpServer().requestHandler(request -> {
            request.response().putHeader("content-type", "text/plain")
                    .end("Hello World!");
        }).listen(8080);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
