package com.usecase.leetcode.editor.dfs.cn1254;
//有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。 
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。 
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。 
//
// 请返回封闭岛屿的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1
//,0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;//行数
        int n = grid[0].length;//列数

        //把第1列和最后1列的陆地都变成海水
        for (int i = 0; i < m; i++) {
            floodIslands(grid, i, 0);
            floodIslands(grid, i, n - 1);
        }

        //把第1行和最后1行的陆地都变成海水
        for (int j = 0; j < n; j++) {
            floodIslands(grid, 0, j);
            floodIslands(grid, m - 1, j);
        }

        // 遍历 grid，剩下的岛屿都是封闭岛屿
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count = count + 1;
                    floodIslands(grid, i, j);
                }
            }

        }

        return count;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    private void floodIslands(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // 超出索引边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        // 已经是海水了
        if (grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;

        // 淹没上下左右的陆地
        floodIslands(grid, i - 1, j);
        floodIslands(grid, i + 1, j);
        floodIslands(grid, i, j - 1);
        floodIslands(grid, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
