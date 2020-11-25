package heap;

/**
 * @ProjectName: structure
 * @Package: heap
 * @ClassName: SortHeap
 * @Author: zwj
 * @Description: 注释 实现堆排序
 * @Date: 2019/10/31 11:23
 * @Version: 1.0
 */
public class SortHeap {

    /**
     * 1：建堆，2：排序
     */

    public void buildHeap(int[]a,int n){
        for(int i = n/2;i>=1;i--){ // 从下标n/2开始到1的数据进行堆化,下标是n/2+1到n的节点是叶子节点，不需要堆化
            heapify(a,n,i);
        }
    }

    public void sort(int[]a,int n){
        buildHeap(a,n);
        int k = n; // 元素个数
        while(k>1){
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }
    }

    private void heapify(int[]a,int n,int i){
        while(true){
            int maxPos = i;
            if(i*2<=n && a[i]<a[i*2]) maxPos = i*2; // 先比较左子节点 i*2 父节点
            if(i*2+1<=n && a[maxPos]<a[i*2+1]) maxPos = i*2+1; // 再比较右子节点
            if(maxPos == i) break; // 当碰到自己时退出
            swap(a,i,maxPos);
            i=maxPos;
        }
    }

    public void swap(int[]a,int i,int pi){
        int j = a[i];
        a[i] = a[pi];
        a[pi] = j;
    }

}
