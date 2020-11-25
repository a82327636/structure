package thought.dynamic_plan;

/**
 * @ProjectName: structure
 * @Package: thought.dynamic_plan
 * @ClassName: LcsDp
 * @Author: zwj
 * @Description: 注释 最长公共子序列
 * @Date: 2019/11/6 15:57
 * @Version: 1.0
 */
public class LcsDp {

    public int lcs(char[]a,int n,char[]b,int m){
        int[][]maxlcs = new int[n][m];
        for(int j = 0;j<m;++j){ // 初始化0行:a[0..0]与b[0..j]的maxlcs
            if(a[0]==b[j])maxlcs[0][j] = 1;
            else if(j!=0)maxlcs[0][j] = maxlcs[0][j-1];
            else maxlcs[0][j]=0;
        }
        for(int i =0;i<n;++i){ // 初始化0列:a[0..i]与b[0..0]的maxlcs
            if(a[i] == b[0])maxlcs[i][0] = 1;
            else if(i!=0)maxlcs[i][0] = maxlcs[i-1][0];
            else maxlcs[i][0] = 0;
        }
        for(int i=1;i<n;++i){ // 填表
            for(int j = 1;j<m;++j){
                if(a[i] == b[j]){
                    maxlcs[i][j] = max(maxlcs[i-1][j],maxlcs[i][j-1],maxlcs[i-1][j-1]+1);
                }else{
                    maxlcs[i][j] = max(maxlcs[i-1][j],maxlcs[i][j-1],maxlcs[i-1][j-1]);
                }
            }
        }
        return maxlcs[n-1][m-1];
    }

    private int max(int x,int y,int z){
        int maxv = Integer.MIN_VALUE;
        if(x>maxv)maxv = x;
        if(y>maxv)maxv = y;
        if(z>maxv)maxv = z;
        return maxv;
    }

}
