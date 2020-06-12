package com.usecase.vertx.http.handlers;

import io.vertx.ext.web.RoutingContext;

public class ProductController {

    private static ProductController instance = new ProductController();

    private ProductController() {
    }

    public static ProductController getInstance() {
        return instance;
    }

    public static void getById(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().end("get:" + id);
    }

    public static void putById(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().end("put:" + id);
    }

    public static void deleteById(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().end("delete:" + id);
    }

    public static void post(RoutingContext routingContext) {
        String id = routingContext.request().getParam("id");
        routingContext.response().end("post:" + id);
    }

}
