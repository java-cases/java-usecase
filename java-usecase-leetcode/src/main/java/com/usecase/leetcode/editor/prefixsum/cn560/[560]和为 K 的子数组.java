package com.usecase.leetcode.editor.prefixsum.cn560;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prfixSums = new int[n + 1];
        int subArrayCount = 0;

        //计算前缀和
        for (int i = 1; i < prfixSums.length; i++) {
            prfixSums[i] = prfixSums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 子数组 nums[j..i-1] 的元素和
                if (prfixSums[i] - prfixSums[j] == k) {
                    subArrayCount = subArrayCount + 1;
                }
            }
        }

        return subArrayCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
