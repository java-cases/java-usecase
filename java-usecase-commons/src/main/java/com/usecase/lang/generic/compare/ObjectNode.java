package com.usecase.lang.generic.compare;

import java.util.Objects;

public class ObjectNode implements Comparable {
    private Comparable data;
    private ObjectNode next;

    public Object getData() {
        return data;
    }

    public ObjectNode getNext() {
        return next;
    }

    public ObjectNode(Comparable data, ObjectNode next) {
        Objects.requireNonNull(data);
        this.data = data;
        this.next = next;
    }

    public int compareToNext() {
        return this.compareTo(this.getNext());
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }

        if (o == this) {
            return 0;
        }

        if (o.getClass() != ObjectNode.class) {
            throw new ClassCastException(o.getClass() + " cannot be cast to ObjectNode");
        }

        // 将 Object 对象进行转型
        ObjectNode node = (ObjectNode) o;
        return this.data.compareTo(node.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ObjectNode that = (ObjectNode) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
