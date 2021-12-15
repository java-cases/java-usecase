package com.usecase.leetcode.editor.prefixsum.cn304;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumMatrixTest {

    private NumMatrix numMatrix = new NumMatrix(new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}});

    @Test
    public void sumRegion1() {
        int sum = numMatrix.sumRegion(2, 1, 4, 3);
        assertThat(sum, Matchers.is(8));
    }

    @Test
    public void sumRegion2() {
        int sum = numMatrix.sumRegion(1, 1, 2, 2);
        assertThat(sum, Matchers.is(11));
    }

    @Test
    public void sumRegion3() {
        int sum = numMatrix.sumRegion(1, 2, 2, 4);
        assertThat(sum, Matchers.is(12));
    }
}