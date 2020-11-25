package graph.leetcode;

/**
 * @ProjectName: structure
 * @Package: graph.leetcode
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/1 10:13
 * @Version: 1.0
 */
public class Main {

    // 1:岛屿的个数
    // 2:有效的数独

    public static void main(String[] args) {

        // 1:岛屿的个数
        char[][]grid = new char[][]
                {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                };
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(grid));// 深度优先搜索
        //System.out.println(numIslands.numIslands1(grid));// 广度优先搜索


        // 2:有效的数独
//        IsValidSudoku isValidSudoku = new IsValidSudoku();
//        char[][] board = new char[][]{
//                    {'5','5','.','.','7','.','.','.','.'},
//                    {'6','.','.','1','9','5','.','.','.'},
//                    {'.','9','8','.','.','.','.','6','.'},
//                    {'8','.','.','.','6','.','.','.','3'},
//                    {'4','.','.','8','.','3','.','.','1'},
//                    {'7','.','.','.','2','.','.','.','6'},
//                    {'.','6','.','.','.','.','2','8','.'},
//                    {'.','.','.','4','1','9','.','.','5'},
//                    {'.','.','.','.','8','.','.','7','9'}
//        };
//        System.out.println(isValidSudoku.isValidSudoku(board));
    }
}
