package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: BubblingSort
 * @Author: zwj
 * @Description: 注释 冒泡排序
 * @Date: 2019/10/22 9:53
 * @Version: 1.0
 */
public class BubblingSort {


    /**
    *描述 从低到高排序
    *@Param n 数组大小,arrs 数组
    *@Return
    *@Author zwj
    *@Date 2019/10/22
    *@Time 11:34
    *version 1.0
    */
    public void sort(int[]arrs,int n){
        if(n<=1)return;
        for(int i = 0;i<n;++i){
            boolean flag = false; // 提前退出冒泡循环的标志位
            for(int j =0;j<n-i-1;j++){
                if(arrs[j] > arrs[j+1]){
                    int tmp = arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=tmp;
                    flag = true;
                }
            }
            if(!flag)break; // 没有数据交换，提前退出
        }
    }
    
    /**
    *描述 从高到低排序
    *@Param 
    *@Return 
    *@Author zwj
    *@Date 2019/10/22
    *@Time 11:43
    *version 1.0
    */
    public void sort1(int []arrs,int n){
        if(n<=1)return;
        for(int i = 0;i<n;++i){
            boolean flag = false; // 提前退出冒泡循环的标志位
            for(int j =n-1;j>i;j--){
                if(arrs[j] > arrs[j-1]){
                    int tmp = arrs[j];
                    arrs[j]=arrs[j-1];
                    arrs[j-1]=tmp;
                    flag = true;
                }
            }
            if(!flag)break; // 没有数据交换，提前退出
        }
    }
}
