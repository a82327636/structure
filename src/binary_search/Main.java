package binary_search;

/**
 * @ProjectName: structure
 * @Package: binary_search
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/21 14:41
 * @Version: 1.0
 */
public class Main {

    // 1: 实现一个有序数组的二分查找算法
    // 2: 实现模糊二分查找算法(比如大于等于给定值的第一个元素)

    public static void main(String[] args) {

        // 1: 实现一个有序数组的二分查找算法
//        Bsearch  bseach = new Bsearch();
//        int[]arrs = new int[]{2,5,7,23,45,67,76,89,95};
//        System.out.println(bseach.bseach(arrs,9,67)); // 循环实现
//        System.out.println(bseach.bseach1(arrs,0,9-1,67)); // 递归实现


        // 2:实现模糊二分查找算法
        TransFormBsearch transFormBsearch = new TransFormBsearch();
        int[]arrs1 = new int[]{3,5,6,8,8,9,10,};
        // 2.1 查找第一个值等于给定值的元素
        System.out.println(transFormBsearch.bsearch1(arrs1,7,8));
        // 2.2 查找最后一个值等于给定值的元素
        System.out.println(transFormBsearch.bsearch2(arrs1,7,8));
        // 2.3 查找第一个大于等于给定值的元素
        System.out.println(transFormBsearch.bsearch3(arrs1,7,8));
        // 2.4 查找最后一个小于等于给定值的元素
        System.out.println(transFormBsearch.bsearch4(arrs1,7,8));
    }
}
