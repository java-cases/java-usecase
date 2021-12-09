package com.usecase.leetcode.editor.window.cn567;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CheckInclusionSolutionTest {

    @Test
    public void checkInclusion1() {
        Solution solution = new Solution();
        boolean r = solution.checkInclusion("ab", "eidbaooo");

        assertThat(r, Matchers.is(true));
    }

    @Test
    public void checkInclusion2() {
        Solution solution = new Solution();
        boolean r = solution.checkInclusion("ab", "eidboaoo");

        assertThat(r, Matchers.is(false));
    }

    @Test
    public void checkInclusion3() {
        Solution solution = new Solution();
        boolean r = solution.checkInclusion("abc", "ccccbbbbaaaa");

        assertThat(r, Matchers.is(false));
    }

    @Test
    public void checkInclusion4() {
        Solution solution = new Solution();
        boolean r = solution.checkInclusion("abc", "bbbca");
        assertThat(r, Matchers.is(true));
    }
}