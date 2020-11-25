package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: SearchK
 * @Author: zwj
 * @Description: 注释 寻找数组中第k大元素
 * @Date: 2019/10/23 15:19
 * @Version: 1.0
 */
public class SearchK {


    public void search(int[]a,int n,int k){
        sort(a, 0, n-1,k);
    }

    public void sort(int[] a, int p, int r,int k){
        if(p>=r) {
            System.out.println(a[p]);
            return;
        }
        int q = partition1(a, p, r); // i,j不同方向出发,获取分区点
        // int q = QuickSort.partition(a, p, r); // i,j同方向出发，获取分区点
        /**
         * 最容易弄混的就是q的下标和q范围内的数据量
         */
        if(k==q+1){
            System.out.println(a[q]);
            return;
        }
        if (k < q+1) {
            sort(a, p, q-1,k);
        } else {
            sort(a, q+1, r,k-q);
        }
    }


    public int partition1(int[] a, int p, int r) {
        int i,j,temp,t;
        i=p;
        j=r;
        //temp就是基准位
        temp = a[p];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp>=a[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp<=a[i]&&i<j) {
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
