package com.usecase.leetcode.editor.dfs.cn695;
//给你一个大小为 m x n 的二进制矩阵 grid 。
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 淹没岛屿，并更新最大岛屿面积
                maxCount = Math.max(maxCount, countAndFloodIslands(grid, i, j));
            }
        }

        return maxCount;
    }

    // 淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
    private int countAndFloodIslands(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // 超出索引边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        // 已经是海水了
        if (grid[i][j] == 0) {
            return 0;
        }

        // 将 (i, j) 变成海水
        grid[i][j] = 0;

        // 淹没上下左右的陆地
        int islandsCount = 1 + countAndFloodIslands(grid, i - 1, j) +
                countAndFloodIslands(grid, i + 1, j) +
                countAndFloodIslands(grid, i, j - 1) +
                countAndFloodIslands(grid, i, j + 1);

        return islandsCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
