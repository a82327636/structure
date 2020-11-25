package thought.leetcode;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/5 9:47
 * @Version: 1.0
 */
public class Main {

    // 1: 正则表达式匹配
    // 3: 零钱兑换
    // 4: 买卖股票的最佳时机
    // 5: 乘积最大子序列
    // 6: 三角形最小路径和


    public static void main(String[] args) {
        // 6: 三角形最小路径和
//        TriangleMinSum triangleMinSum = new TriangleMinSum();
//        //System.out.println(triangleMinSum.minimumTotal());// 回溯算法 递归
//        System.out.println(triangleMinSum.minimumTotal2()); // 动态规划 迭代递推


        // 5: 乘积最大子序列
//        MaxProduct maxProduct = new MaxProduct();
//        int[]nums = new int[]{2,3,-2,4};
//        System.out.println(maxProduct.maxProduct(nums));

        // 1: 正则表达式匹配
//        IsMatch isMatch = new IsMatch();
//        String text = "aa";
//        String pattern = "a*";
//        System.out.println(isMatch.isMatch1(text,pattern));

        // 3: 零钱兑换
//        CoinChange coinChange = new CoinChange();
//        System.out.println(coinChange.coinChange(11));  // 暴力递归
//        System.out.println(coinChange.coinChange1(11)); // 动态规划

        // 4: 买卖股票的最佳时机(与求数组最长递增序列雷同)
        MaxProfit maxProfit = new MaxProfit();
        int[]num = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit.maxProfit1(num));

//        MaxProfitII maxProfitII = new MaxProfitII();
//        int[]num = new int[]{7,1,5,3,6,4};
//        System.out.println(maxProfitII.maxProfit1(num));

//        MaxProfitIII maxProfitIII = new MaxProfitIII();
//        int[]num = new int[]{7,1,5,3,6,4};
//        System.out.println(maxProfitIII.maxProfit_k_2(num));

//        MaxProfitIV maxProfitIV = new MaxProfitIV();
//        int[]num = new int[]{7,1,5,3,6,4};
//        System.out.println(maxProfitIV.maxProfit_k_any(1,num));

    }

}
