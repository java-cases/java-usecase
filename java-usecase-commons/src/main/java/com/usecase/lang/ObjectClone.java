package com.usecase.lang;

import java.util.Arrays;
import java.util.Objects;

public class ObjectClone implements Cloneable {

    private int x;
    private int y;
    private int[] items;

    //演示用，不要暴露内部引用类型数据
    public int[] getItems() {
        return items;
    }

    public int[] copyItems() {
        return Arrays.copyOf(items, items.length);
    }


    public ObjectClone(int x, int y) {
        this.x = x;
        this.y = y;
        this.items = new int[]{x, y, x + y};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ObjectClone that = (ObjectClone) o;

        return this.x == that.x &&
                this.y == that.y &&
                Arrays.equals(this.items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.x, this.y);
        result = 31 * result + Arrays.hashCode(this.items);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ObjectClone shallowClone() throws CloneNotSupportedException {
        return (ObjectClone) super.clone();
    }

    public ObjectClone deepClone() throws CloneNotSupportedException {
        ObjectClone clone = (ObjectClone) super.clone();

        // 创建新对象，并拷贝内容
        clone.items = new int[this.items.length];
        for (int i = 0; i < this.items.length; i++) {
            clone.items[i] = this.items[i];
        }
        return clone;
    }

}
