package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: QuickSort
 * @Author: zwj
 * @Description: 注释 快速排序
 * @Date: 2019/10/23 11:40
 * @Version: 1.0
 */
public class QuickSort {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition1(a, p, r); // i,j不同方向出发,获取分区点
        // int q = partition(a, p, r); // i,j同方向出发，获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }


    /**
     * i , j 同一方向同时出发，j++一直向前，当遇到a[j]<枢轴点时，需要做交换
     *  如果交换时i与j在同一点上，不做交换，i++.
     *  如果i,j不在同一点上，则i与j做交换
     *  (还有一种方法，是i,j从不同两边向中间出发)
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r]; // 选最后一位元素为枢轴点。
        int i = p; // 这里i 和 j 是从同一方向出发
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        // 最后，将i所在的值与枢轴点的值做交换,将枢轴点放至到中间位置
        // 枢轴点左侧是小于它的值，右侧是大于它的值.
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        //System.out.println("i=" + i);
        return i;
    }


    /**
     * i,j从不同两边向中间出发
     * @param a
     * @param p
     * @param r
     * @return
     */
    public static int partition1(int[] a, int p, int r) {
        int i,j,temp,t;
        i=p;
        j=r;
        //temp就是基准位
        temp = a[p];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=a[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=a[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        int v = i;
        a[p] = a[i];
        a[i] = temp;
        return v;
    }

}
