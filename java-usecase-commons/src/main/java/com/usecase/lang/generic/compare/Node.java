package com.usecase.lang.generic.compare;

import java.util.Objects;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        Objects.requireNonNull(data);
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public int compareToNext() {
        return this.compareTo(this.getNext());
    }

    @Override
    public int compareTo(Node<T> o) {
        if (o == null) {
            return 1;
        }

        if (o == this) {
            return 0;
        }

        return this.data.compareTo(o.data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
