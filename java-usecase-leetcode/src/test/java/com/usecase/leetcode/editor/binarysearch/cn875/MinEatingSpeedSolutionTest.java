package com.usecase.leetcode.editor.binarysearch.cn875;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinEatingSpeedSolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void minEatingSpeed() {
        int speed = solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        assertThat(speed, Matchers.is(4));
    }
}