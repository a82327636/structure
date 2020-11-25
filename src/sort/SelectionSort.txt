package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: SelectionSort
 * @Author: zwj
 * @Description: 注释 选择排序
 * @Date: 2019/10/22 15:12
 * @Version: 1.0
 */
public class SelectionSort {

    /***
     * 选择排序，每次找未排序区间的最小值，放入已排序区间的末尾(与未排序区间首元素交换，初始化情况下与首元素交换)
     * 初始情况下，已排序区间只有首个元素，其余都为未排序区间
     */


    public void sort(int[]arrs,int n){
        if(n<=1)return;
        int sortIndex = 0; // 存放已排序区间的末尾索引
        int minValueIndex = n-1; // 存放未排序区间最小值索引
        while (sortIndex<n){
            for(int i =n-1 ;i>=sortIndex+1;i--){ // 查未排序区间
                if(arrs[minValueIndex]>arrs[i-1]){
                    minValueIndex = i-1;
                }
            }
            int tmp = arrs[sortIndex];
            arrs[sortIndex] = arrs[minValueIndex];
            arrs[minValueIndex] = tmp;
            sortIndex++;
            minValueIndex = n-1;
        }


    }

}
