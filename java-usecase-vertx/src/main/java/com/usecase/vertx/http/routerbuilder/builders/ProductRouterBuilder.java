package com.usecase.vertx.http.routerbuilder.builders;

import com.usecase.vertx.http.handlers.ProductController;
import com.usecase.vertx.http.routerbuilder.AbstractRouterBuilder;
import io.vertx.ext.web.Router;

public class ProductRouterBuilder extends AbstractRouterBuilder {

    @Override
    protected void configRouter(Router router) {

        router.get("/products/:id").handler(ProductController::getById);

        router.put("/products/:id").handler(ProductController::putById);

        router.delete("/products/:id").handler(ProductController::deleteById);

        router.get("/products/actions").handler(request -> {
            String param = request.request().getParam("action");
            request.response().end("action=" + param);
        });

    }
}
