package recursion;

import java.util.HashMap;

/**
 * @ProjectName: structure
 * @Package: recursion.leetcode
 * @ClassName: FibonacciRecurSion
 * @Author: zwj
 * @Description: 注释  编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
 * @Date: 2019/10/21 10:22
 * @Version: 1.0
 */
public class FibonacciRecurSion {

    /**
     * 如果不使用hasmMap来记忆已经处理过的数据，则原递归方法就是一种暴力的方法.
     * 时间复杂度：O(2^n)，树形递归的大小为2^n
     *
     *
     * @param n
     * @return
     */
    public int execute(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        if(hashMap.containsKey(n)){
            return  hashMap.get(n);
        }else{
            int ret = execute(n-1)+execute(n-2);
            hashMap.put(n,ret);
            return execute(n-1)+execute(n-2);
        }
   }
}
