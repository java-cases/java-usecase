package io.vertx.http.routerbuilder;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import java.util.Objects;

public abstract class AbstractRouterBuilder implements RouterBuilder {

    private RouterBuilder successor;

    public RouterBuilder getSuccessor() {
        return successor;
    }

    public void setSuccessor(RouterBuilder successor) {
        Objects.requireNonNull(successor);
        this.successor = successor;
    }


    @Override
    public RouterBuilder successor(RouterBuilder successor) {
        this.setSuccessor(successor);
        return successor;
    }

    @Override
    public Router build(Vertx vertx) {
        Router router = Router.router(vertx);
        this.config(router);
        return router;
    }

    @Override
    public RouterBuilder config(Router router) {
        Objects.requireNonNull(router);

        this.configRouter(router);

        if (this.successor != null) {
            this.successor.config(router);
            return this.successor;
        }

        return this;
    }


    protected abstract void configRouter(Router router);
}
