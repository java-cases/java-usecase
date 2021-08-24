package com.usecase.leetcode.editor.cn7;
//<p>给你一个 32 位的有符号整数 <code>x</code> ，返回将 <code>x</code> 中的数字部分反转后的结果。</p>
//
//<p>如果反转后整数超过 32 位的有符号整数的范围 <code>[−2<sup>31</sup>,  2<sup>31 </sup>− 1]</code> ，就返回 0。</p>
//<strong>假设环境不允许存储 64 位整数（有符号或无符号）。</strong>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 123
//<strong>输出：</strong>321
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = -123
//<strong>输出：</strong>-321
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 120
//<strong>输出：</strong>21
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 0
//<strong>输出：</strong>0
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>-2<sup>31</sup> <= x <= 2<sup>31</sup> - 1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 3013</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int result = x;
        int remainder = 0;
        int reversed = 0;

        while (result != 0) {
            //Integer.MAX_VALUE = 214748364 * 10 +7
            if (reversed > 214748364 || (reversed == 214748364 && remainder > 7)) {
                return 0;
            }

            //Integer.MIN_VALUE = -214748364 * 10 -8
            if (reversed < -214748364 || (reversed == 214748364 && remainder < -8)) {
                return 0;
            }

            remainder = result % 10;
            reversed = reversed * 10 + remainder;

            result = result / 10;
        }

        return reversed;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
