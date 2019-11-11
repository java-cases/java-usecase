package io.vertx.http.handlers;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class ProductActionsController implements Handler<RoutingContext> {

    private static ProductActionsController instance = new ProductActionsController();

    private ProductActionsController() {

    }

    public static ProductActionsController getInstance() {
        return instance;
    }


    @Override
    public void handle(RoutingContext routingContext) {

    }
}
