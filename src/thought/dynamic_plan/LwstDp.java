package thought.dynamic_plan;

/**
 * @ProjectName: structure
 * @Package: thought.dynamic_plan
 * @ClassName: LwstDp
 * @Author: zwj
 * @Description: 注释 莱温斯坦最短编辑距离
 * @Date: 2019/11/6 14:29
 * @Version: 1.0
 */
public class LwstDp {


    private char[]a = "mitcmu".toCharArray();
    private char[]b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    public int minDist = Integer.MAX_VALUE; // 存储回溯算法结果


    // 回溯算法 调用recall(0,0,0)

    /**
     * 核心思路
     * 主要是取到最小的编辑距离 minDist
     * 当i==n||j==m时，只是表示了根据某一个中方法，已经执行完然后获取到了最后的edist，如果其他方法执行完后edist更加小，则使用其他方法的edist
     */
    public void recall(int i,int j,int edist){
        if(i == n|| j == m){
            if(i<n)edist +=(n-i);
            if(j<m)edist +=(m-j);
            if(edist < minDist)minDist= edist;
            return;
        }
        if(a[i] == b[j]){ // 两个字符匹配
            recall(i+1,j+1,edist);
        }else{ // 两个字符不匹配
            recall(i+1,j,edist+1);// 删除a[i]或者b[j]前添加一个字符
            recall(i,j+1,edist+1);// 删除b[j]或者a[i]前添加一个字符
            recall(i+1,j+1,edist+1);// 将a[i]和b[j]替换为相同字符
        }
    }

    // 动态规划

    /**
     * 最重要的是画出递归树，然后再填表
     */
    public int lwst(char[]a,int n,char[]b,int m){
        int[][]minDist = new int[n][m];
        for(int j=0;j<m;++j){ // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if(a[0] == b[j])minDist[0][j] = j;
            else if(j!=0)minDist[0][j]= minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        for(int i = 0;i<n;++i){ // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if(a[i] == b[0])minDist[i][0] = i;
            else if(i!=0)minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for(int i = 1;i<n;++i){ // 按行填表
            for(int j = 1;j<m;++j){
                if(a[i] == b[j]){
                    minDist[i][j] = min(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]);// minDist[i-1][j-1]不需要+1,因为可能上面一步操作由三种方式(a+1,b+1,a==b)
                }else{
                    minDist[i][j] = min(minDist[i-1][j]+1,minDist[i][j-1]+1,minDist[i-1][j-1]+1); // 都需要+1,因为都往下走了一步
                }
            }
        }
        return minDist[n-1][m-1];
    }

    private int min(int x,int y,int z){
        int minv = Integer.MAX_VALUE;
        if(x<minv)minv = x;
        if(y<minv)minv = y;
        if(z<minv)minv = z;
        return minv;
    }

}
