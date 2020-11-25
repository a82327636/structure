package thought.dynamic_plan;

/**
 * @ProjectName: structure
 * @Package: thought.dynamic_plan
 * @ClassName: MinDist
 * @Author: zwj
 * @Description: 注释 最短距离
 * @Date: 2019/11/5 15:51
 * @Version: 1.0
 */
public class MinDist {

    private int[][]matrix;

    public MinDist(){
        matrix = new int[][]{
                {1,3,5,9},
                {2,1,3,4},
                {5,2,6,7},
                {6,8,4,3},
        };
    }

    // 状态转移表方法
    public int minDistDP(int n){
        int[][]states = new int [n][n];
        int sum = 0;
        for(int j = 0;j<n;++j){ // 初始化states的第一行数据
            sum+= matrix[0][j];
            states[0][j] = sum; // 矩阵位置数据叠加
        }
        sum = 0;
        for(int i = 0;i<n;++i){ // 初始化states的第一列数据
            sum+= matrix[i][0];
            states[i][0] = sum;
        }
        for(int i = 1;i<n;++i){
            for(int j=1;j<n;++j){
                states[i][j] = matrix[i][j]+Math.min(states[i][j-1],states[i-1][j]);
            }
        }
        return states[n-1][n-1];
    }

    // 使用一维数组
    public int minDistDP() {
        int[] dp = new int[matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if(i == matrix.length - 1 && j != matrix[0].length - 1) // 最后一行&不是最后一列
                    dp[j] = matrix[i][j] +  dp[j + 1];
                else if(j == matrix[0].length - 1 && i != matrix.length - 1)//  最后一列&不是最后一行
                    dp[j] = matrix[i][j] + dp[j];
                else if(j != matrix[0].length - 1 && i != matrix.length - 1)// 不是最后一列&不是最后一行
                    // 处于其余位置的状态值需要比较自己和自己之前的状态值
                    dp[j] = matrix[i][j] + Math.min(dp[j], dp[j + 1]);// 这里的dp[j]相当于下一行这一列的值(从下往上计算)，而dp[j+1]则相当于右侧列最新的值
                else
                    dp[j] = matrix[i][j]; // 最后一行&最后一列
            }
        }
        return dp[0];
    }


    private int[][]mem = new int[4][4];


    // 状态转移方程方法(递归加备忘录方式 还有迭代递推方式与状态转移表的代码实现相同，只是思路不同)
    public int minDist(int i,int j){ // 调用minDist(n-1,n-1),往左、往上走
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if(mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE; // 最小左侧值
        if(j-1>=0){
            minLeft = minDist(i,j-1);
        }
        int minUp = Integer.MAX_VALUE; // 最小上侧值
        if(i-1>=0){
            minUp = minDist(i-1,j);
        }
        int currMinDist = matrix[i][j]+Math.min(minLeft,minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

}
