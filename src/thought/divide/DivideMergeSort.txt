package thought.divide;

/**
 * @ProjectName: structure
 * @Package: thought.divide
 * @ClassName: DivideMergeSort
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/5 11:23
 * @Version: 1.0
 */
public class DivideMergeSort {

    private int num = 0; // 逆序对个数

    public int count(int[]a,int n){
        num = 0;
        mergeSortCounting(a,0,n-1);
        return num;
    }

    private void mergeSortCounting(int[]a,int p,int r){
        if(p>=r)return;
        int q = (p+r)/2;
        mergeSortCounting(a,p,q);
        mergeSortCounting(a,q+1,r);
        merge(a,p,q,r); // 上面两个方法mergeSortCounting,都是为了取数据然后处理merge。
    }

    private void merge(int[]a,int p,int q ,int r){
        int i = p,j=q+1,k = 0;
        int[]tmp = new int[r-p+1]; // 结尾-开头=长度
        while(i<=q && j<=r){
            if(a[i]<a[j]){
                tmp[k++] = a[i++];
            }else{
                num += (q-i+1); // 统计p-q之间，比a[j]大的元素个数 (这里的逆序对个数就是算，两个有序数组之间，q--p中有多少个比a[j]大的数,a[j]取值q+1--r)
                tmp[k++] = a[j++];
            }
        }
        while(i<=q){ // 表示q+1--r区间的值已经取完
            tmp[k++]=a[i++];
        }
        while(j<=q){ // 表示p--q区间的值已经取完
            tmp[k++]=a[j++];
        }

        for(i =0;i<r-p;++i){ // 将临时表中的数据拷贝到原始数组a中
            a[p+i] = tmp[i];  // 这里是从a[p+i]开始
        }
    }
}
