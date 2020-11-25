package graph.leetcode;

/**
 * @ProjectName: structure
 * @Package: graph.leetcode
 * @ClassName: IsValidSudoku
 * @Author: zwj
 * @Description: 注释 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。

 *
 * @Date: 2019/11/4 14:59
 * @Version: 1.0
 */
public class IsValidSudoku {

    /**
     * 主要两个要点：
     * 1、只遍历一次如何储存数据；
     * 2、判断是在一个3*3的框中的方法。
     *
     * 1、使用了2进制的9个位数，如果是第一个数是1，那么统计标志就是0000000010(二进制 1左移1位)，
     * 如果第二个数是3那么统计标识变为0000001010(二进制 1左移3位再加上原来的)，
     *
     * 每次判断有没有重复就右移相应位数之后整除2即可。
     *
     * 2、获取3*3的宫格,同官方解法int boxNum = i / 3 * 3 + j / 3;如果是0,1,2行的话整除3就是0，
     * 然后再加上列数整除3，这样就把整个9*9分为了编号0-8的9个3*3的区域。(因为整除3的缘故)

     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[] rowCnt = new int[9]; // 行
        int[] colCnt = new int[9]; // 列
        int[] boxCnt = new int[9]; // 3*3 宫格
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int num = board[i][j] - 48; //  48是ASCII == '0',因为char是字符，需要改为ASCII码，可以获取需要移动几位
                // 处理行
                System.out.print(Integer.toBinaryString(rowCnt[i]));
                if ((rowCnt[i] >> num) % 2 == 1) { // 判断有没有重复值(只有整除的情况才说明没有重复，因为>>num == 抹去num-1位，当末尾为1时，这时1%2 == 1)
                    return false;
                } else {
                    rowCnt[i] += 1 << num; // 1左移num位,左移1位010，左移两位0100...
                }
                // 处理列
                if ((colCnt[j] >> num) % 2 == 1) { // 判断有没有重复值
                    return false;
                } else {
                    colCnt[j] += 1 << num;
                }
                // 处理框
                int boxNum = i / 3 * 3 + j / 3; // (0-8号 9个)
                if ((boxCnt[boxNum] >> num) % 2 == 1) { // 判断有没有重复值
                    return false;
                } else {
                    boxCnt[boxNum] += 1 << num;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(1%2);
    }

}