package graph.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: graph.leetcode
 * @ClassName: NumIslands
 * @Author: zwj
 * @Description: 注释 岛屿的数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1 (因为图中的1都可以关联起来)
 *
 *
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3 (图中的1被0隔断为3个)

 *
 * @Date: 2019/11/4 14:10
 * @Version: 1.0
 */
public class NumIslands {


    // dfs 深度优先搜索
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length; // 行长度
        int nc = grid[0].length; // 列长度
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') { // 等于1进入
                    ++num_islands;
                    dfs(grid, r, c); // 太多多余的判断了
                }
            }
        }
        return num_islands;
    }

    // dfs深度优先搜索（邻接矩阵表示法）
    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') { // 等于0返回
            return;
        }

        grid[r][c] = '0'; // 能被访问到的都设为0
        dfs(grid, r - 1, c); // 行-1
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }




    /**
     * 广度优先搜索算法
     *
     * 核心算法代码
     *
     *  int row = id / nc;
     *  int col = id % nc;
     *
     * neiors.add(row * nc + col);
     *
     * id = row * nc + col(余数)
     * row = id / nc (如函数中的比例)
     * col = id % nc (如函数中y的截距)
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length; // 5
        int nc = grid[0].length; // 5
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') { // 从1开始
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited ,把访问到的都设置为0
                    Queue<Integer> neiors = new LinkedList<>();
                    neiors.add(r * nc + c); // 将grid[r][c]为根节点,坐标转为数字，启动广度优先搜索
                    // 根据一点，做广度优先搜索，然后把所有可以关联上的（上下左右）都设置为0，直到找不到1，然后跳出来继续执行for
                    while (!neiors.isEmpty()) {
                        int id = neiors.remove();
                        // 根据这个数字 r * nc + c 算出行与列的坐标
                        int row = id / nc; // 获取行(因为存储时，都乘以了nc),因为行数不固定，所以使用/
                        int col = id % nc; // 获取列(因为存储时，都乘以了nc),因为列数是固定的nc,所以使用了%
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neiors.add((row-1) * nc + col); // 将grid[row-1][col]存储为根节点
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neiors.add((row+1) * nc + col); // 将grid[row+1][col]存储为根节点
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neiors.add(row * nc + col-1); // 将grid[row][col-1]存储为根节点
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neiors.add(row * nc + col+1); // 将grid[row][col+1]存储为根节点
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i/5);
        System.out.println(i%5);
    }

}
