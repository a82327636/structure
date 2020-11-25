package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: MergeSort
 * @Author: zwj
 * @Description: 注释 归并排序
 * @Date: 2019/10/22 16:56
 * @Version: 1.0
 */
public class MergeSort {

    /**
     *
     * @param a 数组
     * @param n 数组长度
     */
    public void merge_sort(int[]a,int n){
        mergeSortInternally(a,0,n-1);
    }


    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        //merge(a, p, q, r); //不使用哨兵
        //mergeBySentry(a, p, q, r);// 使用哨兵从小到大
        mergeBySentry1(a, p, q, r); // 使用哨兵从大到小
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }


    /**
     * 合并(哨兵) 从小到大
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p; // 因为始终是同一个数组
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            //(因为左右数组都在末尾增加了最大值，所以会触发到哨兵,而哨兵是最大的值)
            if (leftArr[i] <= rightArr[j] ) { //触发哨兵机制则跳转
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }


    /**
     * 合并(哨兵) 从大到小
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry1(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最小值）
        leftArr[q - p + 1] = Integer.MIN_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最小值）
        rightArr[r-q] = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (leftArr[i] > rightArr[j] ) { //触发哨兵机制则跳转
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }


    public static void main(String[] args) {
//        int[]a = new int[]{2,3,1};
//        int bIndex = 0;
//        int eIndex = a.length-1;
//        int q=bIndex+(eIndex-bIndex)/2;
//        int[]a1 = new int[q];
//        int[]a2 = new int[eIndex-q+1];
//        System.arraycopy(a,0,a1,0,q);
//        System.arraycopy(a,q,a2,0,eIndex-q+1);
//        System.out.println(a1);
         int[]b = new int[]{1};
         System.out.println(b.length);
    }
}
