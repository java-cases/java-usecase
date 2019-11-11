package io.vertx.http.routerbuilder.builders;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.http.routerbuilder.AbstractRouterBuilder;

public class IndexRouterBuilder extends AbstractRouterBuilder {

    @Override
    protected void configRouter(Router router) {

        router.route(HttpMethod.GET, "/get").handler(request -> {
            request.response().end("get");
        });

        router.route("/index/*").order(3).handler(request -> {
            request.response().end("*");
        });

        router.route("/index").order(2).handler(request -> {
            request.response().end("index");
        });

        router.route("/index/main").order(1).handler(request -> {
            request.response().end("main");
        });
    }
}
