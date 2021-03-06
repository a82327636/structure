package thought.leetcode;

import java.util.Arrays;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: MaxProfit
 * @Author: zwj
 * @Description: 注释 买卖股票最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 *
 * @Date: 2019/11/8 15:04
 * @Version: 1.0
 */
public class MaxProfit {

    /**
     * 一次遍历 (只记录峰谷值)
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }



    // 牛顿莱布尼茨求和公式 (部分的变化之和就是总体的变化)
    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;
        int[]diff = new int[prices.length-1];
        for (int i = 0; i < prices.length - 1; ++i) {
            diff[i] = prices[i+1] - prices[i];
        }
        int[]dp = new int[diff.length];
        dp[0] = Math.max(0, diff[0]);
        int profit = dp[0];
        for (int i = 1; i < diff.length; ++i) {
            dp[i] = Math.max(0, dp[i-1] + diff[i]); // 将部分变化的和相加
            profit = Math.max(profit, dp[i]);
        }
        return profit;
    }


}
