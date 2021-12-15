package com.usecase.leetcode.editor.dfs.cn1254;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClosedIslandSolutionTest {

    @Test
    public void closedIsland1() {
        Solution solution = new Solution();
        int count = solution.closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}});

        assertThat(count, Matchers.is(2));

    }

    @Test
    public void closedIsland2() {
        Solution solution = new Solution();
        int count = solution.closedIsland(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}});

        assertThat(count, Matchers.is(1));
    }

    @Test
    public void closedIsland3() {
        Solution solution = new Solution();
        int count = solution.closedIsland(new int[][]{
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}});

        assertThat(count, Matchers.is(5));
    }
}