package com.usecase.leetcode.editor.doublepionter.cn344;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReverseStringSolutionTest {

    @Test
    public void reverseString() {
        Solution solution = new Solution();

        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(chars);
        assertThat(chars, Matchers.equalTo(new char[]{'o', 'l', 'l', 'e', 'h'}));
    }
}