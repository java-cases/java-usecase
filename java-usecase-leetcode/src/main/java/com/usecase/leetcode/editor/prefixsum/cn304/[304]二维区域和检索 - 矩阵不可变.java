package com.usecase.leetcode.editor.prefixsum.cn304;
//给定一个二维矩阵 matrix，以下类型的多个请求：
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
// Related Topics 设计 数组 矩阵 前缀和 👍 328 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private final int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // preSum[i][j] 记录矩阵 [0, 0, i, j] 的元素和
        prefixSums = new int[m + 1][n + 1];

        // 计算每个矩阵 [0, 0, i, j] 的元素和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //(i,j)点的元素和 = 上1顶点矩阵元素和 +
                // 左1顶点矩阵元素和 -
                // 上1对角顶点矩阵元素和 +
                // 上1顶点元素的值
                prefixSums[i][j] = prefixSums[i - 1][j] +
                        prefixSums[i][j - 1] -
                        prefixSums[i - 1][j - 1] +
                        matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 包括左对角和右对角在内
        // 子矩阵元素和 = 右对角（row2，col2）元素和 -
        // 左对角（row1，col1）右col2 + 1顶点矩阵元素和 -
        // 左对角（row1，col1）下row2 + 1顶点矩阵元素和 +
        // 左对角（row1，col1）顶点矩阵元素和(不含)
        return prefixSums[row2 + 1][col2 + 1] -
                prefixSums[row1][col2 + 1] -
                prefixSums[row2 + 1][col1] +
                prefixSums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
