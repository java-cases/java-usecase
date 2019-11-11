package io.vertx.http.routerbuilder.builders;

import io.vertx.ext.web.Router;
import io.vertx.http.handlers.ProductController;
import io.vertx.http.routerbuilder.AbstractRouterBuilder;

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
