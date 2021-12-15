package com.usecase.leetcode.editor.array.cn303;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumRangeNumArrayTest {

    private final NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

    @Test
    public void sumRange0to2() {
        int sum = numArray.sumRange(0, 2);
        assertThat(sum, Matchers.is(1));
    }

    @Test
    public void sumRange2to5() {
        int sum = numArray.sumRange(2, 5);
        assertThat(sum, Matchers.is(-1));
    }

    @Test
    public void sumRange0to5() {
        int sum = numArray.sumRange(0, 5);
        assertThat(sum, Matchers.is(-3));
    }
}