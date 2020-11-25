package thought.recall;

/**
 * @ProjectName: structure
 * @Package: thought.recall
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 回溯算法(在一组可能的解中，搜索满足期望的解)
 * @Date: 2019/11/5 9:34
 * @Version: 1.0
 */
public class Main {

    // 1: 利用回溯算法求解八皇后问题
    // 2: 利用回溯算法求解0-1背包问题

    public static void main(String[] args) {

        // 1: 利用回溯算法求解八皇后问题
        EightQueen eightQueen = new EightQueen();
        eightQueen.cal8queens(0);

        // 2: 利用回溯算法求解0-1背包问题
//        Knapsack knapsack = new Knapsack();
//        int[]a = new int[]{5,15,25};
//        knapsack.f(0,0,a,3,35);
//        System.out.println(knapsack.maxW);
    }
}
