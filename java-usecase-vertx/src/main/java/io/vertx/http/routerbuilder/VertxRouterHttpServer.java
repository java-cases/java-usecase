package io.vertx.http.routerbuilder;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.http.routerbuilder.builders.IndexRouterBuilder;
import io.vertx.http.routerbuilder.builders.ProductRouterBuilder;

public class VertxRouterHttpServer extends AbstractVerticle {

    @Override
    public void start() {
        RouterBuilder builder = new IndexRouterBuilder();
        builder.successor(new ProductRouterBuilder());

        Router router = builder.build(this.getVertx());

        Handler<HttpServerRequest> requesHandler = (HttpServerRequest req) -> router.accept(req);

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(requesHandler);
        server.listen(8080);
    }

}
