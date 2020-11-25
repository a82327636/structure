package thought.recall;

/**
 * @ProjectName: structure
 * @Package: thought.recall
 * @ClassName: Knapsack
 * @Author: zwj
 * @Description: 注释 0-1背包问题
 * @Date: 2019/11/5 10:33
 * @Version: 1.0
 */
public class Knapsack {

    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    /**
     *
     * @param i 表示考察到哪个物品了
     * @param cw 表示当前已经装进去的物品的重量和；
     * @param items 每个物品的重量
     * @param n 物品个数
     * @param w 背包重量
     *
     * 假设背包可承受重量35,物品个数3,物品重量存储在数组a中,可以这样调用函数:
     *          f(0,0,a,3,35)
     */
    public void f(int i,int cw,int[]items,int n,int w){
        if(cw == w || i == n){
            if(cw>maxW) maxW = cw; // 重要的判断，maxW是所有物品都放一遍后，值最大的.
            return;
        }
        f(i+1,cw,items,n,w); // 先将每个物品都放进去验证
        if(cw + items[i]<=w){ // 如果验证通过，可以进入下面放入值，已经超过可以背包承受的重量的时候，就不要再装了.
            f(i+1,cw+items[i],items,n,w);
        }
    }

}
