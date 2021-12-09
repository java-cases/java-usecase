package com.usecase.leetcode.editor.math.cn13;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class RomanToIntSolutionTest {

    @Test
    void romanToInt() {
        Solution solution = new Solution();

        assertThat(solution.romanToInt("III"), Matchers.is(3));

        assertThat(solution.romanToInt("IV"), Matchers.is(4));

        assertThat(solution.romanToInt("IX"), Matchers.is(9));

        assertThat(solution.romanToInt("LVIII"), Matchers.is(58));

        assertThat(solution.romanToInt("MCMXCIV"), Matchers.is(1994));
    }
}