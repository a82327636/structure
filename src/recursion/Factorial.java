package recursion;

/**
 * @ProjectName: structure
 * @Package: recursion
 * @ClassName: Factorial
 * @Author: zwj
 * @Description: 注释 阶乘 0!=1，n!=(n-1)!×n
 * @Date: 2019/10/21 10:37
 * @Version: 1.0
 */
public class Factorial {


    public int execute(int n){
        if(n==0)return 1;
        return execute(n-1)*n;
    }

}
