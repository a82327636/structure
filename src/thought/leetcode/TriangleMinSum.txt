package thought.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: TriangleMinSum
 * @Author: zwj
 * @Description: 注释  三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 *
 * @Date: 2019/11/7 16:00
 * @Version: 1.0
 */
public class TriangleMinSum {


    private List<List<Integer>> triangle;

    public TriangleMinSum(){
        triangle = new ArrayList<>();
        List<Integer>list1 = new ArrayList<>();
        list1.add(2);
        List<Integer>list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer>list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer>list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
    }

    // 递归【超时】
    int row;
    public int minimumTotal() {
        row=triangle.size();
        return helper(0,0, triangle);
    }
    private int helper(int level, int c, List<List<Integer>> triangle){
        // System.out.println("helper: level="+ level+ " c=" + c);
        if (level==row-1){
            return triangle.get(level).get(c);
        }
        int left = helper(level+1, c, triangle);
        int right = helper(level+1, c+1, triangle);
        return Math.min(left, right) + triangle.get(level).get(c);
    }


    // 自顶向下, 记忆化搜索 【AC】
    Integer[][] memo;

    public int minimumTotal1() {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0,0, triangle);
    }
    private int helper1(int level, int c, List<List<Integer>> triangle){
        // System.out.println("helper: level="+ level+ " c=" + c);
        if (memo[level][c]!=null)
            return memo[level][c];
        if (level==row-1){
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level+1, c, triangle);
        int right = helper(level+1, c+1, triangle);
        return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    }

    // 自底向上, DP(动态规划) 【AC】

    /**
     * 动态规划思路
     * 1：使用一维数组记录数字，最大个数为最后一行字数+1
     * 2：先将最后一行数字填入数组，然后开始与上一行的值相加（先比较本行i与i+1哪一个更小）
     * 3: 顶行只需要要填入minlen[0]
     */
    public int minimumTotal2() {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }


}
