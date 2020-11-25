package thought.divide;

/**
 * @ProjectName: structure
 * @Package: thought.divide
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/5 9:35
 * @Version: 1.0
 */
public class Main {

    // 1: 利用分治算法求一组数据的逆序对个数

    public static void main(String[] args) {

        // 1: 利用分治算法求一组数据的逆序对个数
        DivideMergeSort divideMergeSort = new DivideMergeSort();
        int[]a = new int[]{1,5,6,2,3,4};
        System.out.println(divideMergeSort.count(a,6));
    }
}
