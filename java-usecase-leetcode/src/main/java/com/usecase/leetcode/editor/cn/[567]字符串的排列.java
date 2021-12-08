package com.usecase.leetcode.editor.cn;//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 503 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>(); //被包含子串的字符及其数量
        Map<Character, Integer> matches = new HashMap<>(); //匹配的字符及其数量

        int left = 0; //滑窗左边位置
        int right = 0; //滑窗右边位置

        //计算被包含的字符及其数量
        char[] chars = s1.toCharArray();
        for (char c : chars) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            //窗口中匹配子串的字符及其数量与子串相同
            if (matchedAll(needs, matches)) {
                return true;
            }

            //向右滑动1次，窗口移入1个字符
            char c = s2.charAt(right);
            right = right + 1;

            //如果移入的字符在子串中，更新数据
            if (needs.containsKey(c)) {
                //窗口中的该字符数量加1
                matches.put(c, matches.getOrDefault(c, 0) + 1);
            }

            // 当窗口宽度>=子串长度，左侧窗口要收缩
            while (right - left >= needs.size()) {
                //窗口中匹配子串的字符及其数量与子串相同
                if (matchedAll(needs, matches)) {
                    return true;
                }

                //左位置，向右滑动1次，窗口移出1个字符
                char d = s2.charAt(left);
                left = left + 1;

                //如果移出的字符，满足要求，窗口中的该字符数量减1
                if (needs.containsKey(d)) {
                    matches.put(d, matches.getOrDefault(c, 0) - 1);
                }
            }
        }

        return false;
    }

    private boolean matchedAll(Map<Character, Integer> neededCount, Map<Character, Integer> matchers) {
        return neededCount
                .entrySet()
                .stream()
                .allMatch(entry ->
                        entry.getValue().equals(matchers.getOrDefault(entry.getKey(), -1)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
