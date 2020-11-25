package recursion;

/**
 * @ProjectName: structure
 * @Package: recursion
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 递归
 * @Date: 2019/10/17 14:28
 * @Version: 1.0
 */
public class Main {


    public static void main(String[] args) {

        // 1: 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
//        FibonacciRecurSion fibonacciRecurSion = new FibonacciRecurSion();
//        System.out.println(fibonacciRecurSion.execute(3));

        // 2: 编程实现求阶乘n!
//        Factorial factorial = new Factorial();
//        System.out.println(factorial.execute(5));

        // 3: 编程实现一组数据集合的全排列
        Permutation permutation = new Permutation();
        int[]arr = new int[]{1,2};
        Permutation.sort_it(arr,0);
    }

}
