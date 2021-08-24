package com.usecase.leetcode.editor.cn7;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class SolutionTest {

    @Test
    void reverse() {
        Solution solution = new Solution();

        assertThat(solution.reverse(123), Matchers.is(321));

        assertThat(solution.reverse(-123), Matchers.is(-321));

        assertThat(solution.reverse(120), Matchers.is(21));

        assertThat(solution.reverse(0), Matchers.is(0));
    }
}