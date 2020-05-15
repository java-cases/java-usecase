package com.usecase.guava.common;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreconditionsTest {

    @Test
    public void checkArgument() {
        String lastName = "lastname";

        //检查是否为 true，用来检查传递给方法的参数。
        Preconditions.checkArgument(lastName != null,
                "lastName was null but expected not null");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkArgumentException() {
        String lastName = null;

        //检查是否为 true，用来检查传递给方法的参数。
        Preconditions.checkArgument(lastName != null,
                "lastName was null but expected not null");
    }

    @Test
    public void checkNotNull() {
        String lastName = "lastname";

        //检查 value 是否为 null，该方法直接返回 value
        lastName = Preconditions.checkNotNull(lastName);
        assertEquals("lastname", lastName);
    }

    @Test(expected = NullPointerException.class)
    public void checkNotNullException() {
        String lastName =null;

        //检查 value 是否为 null，该方法直接返回 value
        lastName = Preconditions.checkNotNull(lastName);
    }

    @Test
    public void checkState() {
        String lastName = "lastname";

        //用来检查对象的某些状态。
        Preconditions.checkState(lastName != null,
                "lastName was null but expected not null");
    }

    @Test(expected = IllegalStateException.class)
    public void checkStateException() {
        String lastName = null;

        //用来检查对象的某些状态。
        Preconditions.checkState(lastName != null,
                "lastName was null but expected not null");
    }

    @Test
    public void checkElementIndex() {
        List<String> list = Arrays.asList("a", "b");

        //检查 index 作为索引值对某个列表、字符串或数组是否有效。
        Preconditions.checkElementIndex(0,list.size());
        Preconditions.checkElementIndex(1,list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkElementIndexException() {
        List<String> list = Arrays.asList("a","b");

        //检查 index 作为索引值对某个列表、字符串或数组是否有效。
        Preconditions.checkElementIndex(-1,list.size());
        Preconditions.checkElementIndex(2,list.size());
    }

    @Test
    public void checkPositionIndex() {
        List<String> list = Arrays.asList("a","b");

        //检查 index 作为索引值对某个列表、字符串或数组是否有效。
        Preconditions.checkPositionIndex(0,list.size());
        Preconditions.checkPositionIndex(1,list.size());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkPositionIndexException() {
        List<String> list = Arrays.asList("a","b");

        //检查 index 作为索引值对某个列表、字符串或数组是否有效。
        Preconditions.checkPositionIndex(-1,list.size());
        Preconditions.checkPositionIndex(2,list.size());

    }

}
