package thought.dynamic_plan;

/**
 * @ProjectName: structure
 * @Package: thought.dynamic_plan
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 动态规划(适合解决最优问题，比如求最大值、最小值)
 *
 * 一个模型三个特性 -->理论讲解
 * 一个模型：动态规划适合解决的问题模型（多阶段决策最优解模型）
 * 三个特性: 最优子结构、无后效性、重复子问题
 * @Date: 2019/11/5 9:36
 * @Version: 1.0
 */
public class Main {

    // 1: 0-1背包问题
    // 2: 编程实现莱温斯坦最短编辑距离
    // 3: 编程实现查找两个字符串的最长公共子序列
    // 4: 编程实现一个数据序列的最长递增子序列


    public static void main(String[] args) {
        // 1: 0-1背包问题
//        Knapsack knapsack = new Knapsack();
//        int[] weight = new int[]{5,2,2};
        //System.out.println(knapsack.knapsack(weight,3,8));

        //System.out.println(knapsack.knapsack2(weight,3,8));


//        int[]items = new int[]{50,30,100,120,15,70};
//        knapsack.doublelladvance(items,6,200);

        // 1.2 最短路径
          //MinDist minDist = new MinDist();
          //System.out.println(minDist.minDistDP(4));  // 状态转移表方法
          //System.out.println(minDist.minDistDP()); // 使用一维数组
          //System.out.println(minDist.minDist(4-1,4-1)); //状态转移方程方法

        // 2: 编程实现莱温斯坦最短编辑距离
        LwstDp lwstDp = new LwstDp();
        char[] row = new char[]{'m','i','t','c','m','u'};
        char[] cel = new char[]{'m','t','a','c','n','u'};
        System.out.println(lwstDp.lwst(row,6,cel,6));
        lwstDp.recall(0,0,0);
        System.out.println(lwstDp.minDist);

        // 3: 编程实现查找两个字符串的最长公共子序列
//        LcsDp lcsDp = new LcsDp();
//        char[] row = new char[]{'m','i','t','c','m','u'};
//        char[] cel = new char[]{'m','t','a','c','n','u'};
//        System.out.println(lcsDp.lcs(row,6,cel,6));

        // 4: 编程实现一个数据序列的最长递增子序列
//        LengthOfLIS lengthOfLIS = new LengthOfLIS();
//        int[]nums = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(lengthOfLIS.lengthOfLIS1(nums));
    }


}
