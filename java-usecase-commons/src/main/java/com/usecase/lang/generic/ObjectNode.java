package com.usecase.lang.generic;

import java.util.Objects;

public class ObjectNode {
    private Object data;
    private ObjectNode next;

    public ObjectNode(Object data, ObjectNode next) {
        Objects.requireNonNull(data);
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public ObjectNode getNext() {
        return next;
    }
}
