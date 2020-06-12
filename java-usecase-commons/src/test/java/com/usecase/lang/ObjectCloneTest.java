package com.usecase.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ObjectCloneTest {

    @Test
    public void cloneOverride() throws CloneNotSupportedException {
        ObjectClone obj = new ObjectClone(1, 2);
        ObjectClone clone = (ObjectClone) obj.clone();

        Assert.assertTrue(clone != obj);
        Assert.assertTrue(clone.equals(obj));
        assertEquals(obj, clone);

        Assert.assertTrue(clone.getItems() == obj.getItems());

        clone.getItems()[0] = -1;
        Assert.assertTrue(clone.getItems()[0] == obj.getItems()[0]);
    }

    @Test
    public void shallowClone() throws CloneNotSupportedException {
        ObjectClone obj = new ObjectClone(1, 2);
        ObjectClone clone = obj.shallowClone();

        Assert.assertTrue(clone != obj);
        Assert.assertTrue(clone.equals(obj));
        assertEquals(obj, clone);

        Assert.assertTrue(clone.getItems() == obj.getItems());

        clone.getItems()[0] = -1;
        Assert.assertTrue(clone.getItems()[0] == obj.getItems()[0]);
    }

    @Test
    public void deepClone() throws CloneNotSupportedException {
        ObjectClone obj = new ObjectClone(1, 2);
        ObjectClone clone = obj.deepClone();

        Assert.assertTrue(clone != obj);
        Assert.assertTrue(clone.equals(obj));
        assertEquals(obj, clone);

        Assert.assertTrue(clone.getItems() != obj.getItems());

        clone.getItems()[0] = -1;
        System.out.println(Arrays.toString(obj.getItems()));
        System.out.println(Arrays.toString(clone.getItems()));

        Assert.assertTrue(clone.getItems()[0] != obj.getItems()[0]);
    }


}