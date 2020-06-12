package com.usecase.vertx.http.routerbuilder;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public interface RouterBuilder {

    RouterBuilder successor(RouterBuilder successor);

    Router build(Vertx vertx);

    RouterBuilder config(Router router);
}
