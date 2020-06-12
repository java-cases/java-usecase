package com.usecase.vertx.http;

import com.usecase.vertx.http.handlers.ProductActionsController;
import com.usecase.vertx.http.handlers.ProductController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class VertxHttpServer extends AbstractVerticle {

    @Override
    public void start() {
        Router router = buildRouter();

        HttpServer server = vertx.createHttpServer();
        server.requestHandler((HttpServerRequest request) -> router.accept(request));
        server.listen(8080);
    }

    public Router buildRouter() {
        Router router = Router.router(vertx);

        handleStatic(router);

        router.get("/products/:id").handler(ProductController::getById);
        router.put("/products/:id").handler(ProductController::putById);
        router.delete("/products/:id").handler(ProductController::deleteById);

        //Router subRouter = Router.router(vertx);
        //subRouter.get("/actions").handler(ProductActionsController.getInstance());
        //router.mountSubRouter("/products", subRouter);

        router.get("/actions").handler(ProductActionsController.getInstance());

        return router;
    }

    public void handleStatic(Router router) {
        router.route("/assets/*").handler(StaticHandler.create("assets"));
    }

}
