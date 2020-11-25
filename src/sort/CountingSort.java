package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: CountingSort
 * @Author: zwj
 * @Description: 注释 计数排序
 * @Date: 2019/10/24 10:15
 * @Version: 1.0
 */
public class CountingSort {

    /**
     * 简单思路：计数排序是桶排序的一种特殊情况
     * 如果要排序的数据集合n,所处范围不大，最大值为k,则可以划分k个桶，而每个桶的值都相同，省掉桶内排序时间
     */

    /**
     *
     * @param a 数组
     * @param n 数组大小
     */
    public void countingSort(int[]a,int n){
        if(n<=1)return;

        // 查找数组中的数据范围
        int max = a[0];
        for(int i = 1;i<n;++i){
            if(max<a[i]) {
                max = a[i]; // 按最大值来分桶
            }
        }

        int[]c = new int[max+1];//桶数组[0,max]
        for(int i = 0;i<max;++i){
            c[i] = 0; // 每个桶内值默认都为0
        }

        for(int i=0;i<n;i++){ // 计算每个元素的个数，放入c中
            c[a[i]]++; // a[i]对应不同的值,也就是桶c的下标
        }

        // 依次累加
        /**
         * 巧妙的地方
         * 对数组c顺序求和，这样c[k]中存储的是小于等于k的值
         *
         * 如:0,2,2,4
         *      c[4+1] = new{0(值为1),1(值为0),2(值为2),3(值为0),4(值为1)}
         *  而通过累加后
         *      c[4+1] = new{0(值为1),1(值为1),2(值为3),3(值为3),4(值为4)}
         *
         */
        for(int i = 1;i<=max;++i){
            c[i] = c[i-1]+c[i];
        }

        int[]r = new int[n]; // 存储排序后的数组
        /**
         * 难点
         * 从后到前依次扫描数组a,如：当扫描到3时，可以从数组c中取出下标为3的值如7，也就是说
         *   目前为止，包括自己在内，分数小于等于3的有7个,也是说3是数组r中的第7个元素.
         *   当3放入数组r中后，小于等于3的元素就剩6个了，所以c[3]-1 = 6;
         *  依次类推，当扫描到第二个3时，放入到数组r中的第6个位置(下标为5)。
         */
        for(int i = n-1;i>=0;i--){
            int index = c[a[i]]-1; // 先获取数组c对应a下标的值，如果i是3对应的值为7-1
            r[index] = a[i];       // 把a数组下标为6的数据赋值给数组r
            c[a[i]] --;             // 数组c对应 a下标的值，--,这时3对应的值为6
        }

        for(int i = 0;i<n;++i){ // 把排序好的值从数组 r中拷贝到数组 a中
            a[i] = r[i];
        }
    }
}
