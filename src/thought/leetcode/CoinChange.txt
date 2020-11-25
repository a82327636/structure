package thought.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: CoinChange
 * @Author: zwj
 * @Description: 注释 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * @Date: 2019/11/8 13:47
 * @Version: 1.0
 */
public class CoinChange {

    /**
     * 算法思路
     * 1：amount=11 可以分为子问题 f(11) = f(10),f(9),f(6)
     * 2:f(10) = 11 - 1,f(9) = 11 -2,f(6) = 11 - 5 (最优子优化结构，可以根据获取子问题最小值来得到最终问题最小值)
     *
     * 与爬楼梯的问题一样，如：一次只能爬1或2个，则到20个楼梯有多少种方式 f(20) = f(19)-->[20-1] + f(18)-->[20-2]
     *
     *
     */

    public List<Integer> coins;

    public CoinChange(){
        coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
    }

    // 暴力递归
    public int coinChange(int amount) {
        if (amount == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 金额不可达
            if (amount - coin < 0) continue;
            int subProb = coinChange(amount - coin);
            // 子问题无解
            if (subProb == -1) continue;
            ans = Math.min(ans, subProb + 1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    // 动态规划
    /**
     * 由上面的暴力递归推导出转移方程 f(s) = min(f(s),f(s-ci)+1) ci=币值
     */
    public int coinChange1(int amount) {
        int[]dp = new int[amount + 1];
        for(int i = 0;i<amount+1;i++){
            dp[i] = 11;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins){
                if (coin <= i)// 这时 dp[i-coint]不存在负数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
