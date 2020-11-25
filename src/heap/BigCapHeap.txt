package heap;

/**
 * @ProjectName: structure
 * @Package: heap
 * @ClassName: BigCapHeap
 * @Author: zwj
 * @Description: 注释 大顶堆
 * 大顶堆要求根节点的大于或等于左子树的关键字值，又大于或等于右子树的关键字值
 * @Date: 2019/10/31 10:13
 * @Version: 1.0
 */
public class BigCapHeap {

    /**
     * 堆是一种完全二叉树，所以使用数组来实现可以更好的利用资源，可以单纯的使用数组下标来找到一个节点的左右子节点和父节点
     */

    private int[]a; //数组,从下标1开始存储数据
    private int n;//堆可以存储的最大数据个数
    private int count; // 堆中已存在的数据个数

    public BigCapHeap(int capacity){
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }

    public void insert(int data){
        if(count>=n)return; // 堆满了
        ++count;
        a[count]=data;
        int i = count;
        while(i/2 > 0 && a[i]>a[i/2]){ // 自下往上堆化,父节点下标=节点下标/2
            swap(a,i,i/2);// swap()函数的作用，交换下标为i和i/2的两个元素
            i = i/2;
        }
     }


     public void remvoeMax(){
        if(count == 0)return; // 堆中没有元素
         a[1] = a[count]; // 删除对顶，将堆尾放入对顶的位置
         a[count] = 0;
         --count;
         heapify(a,count,1); //开始堆化，要满足堆的两种规定
     }

     private void heapify(int[]a,int n,int i){ // 自上往下堆化
        while(true){
            int maxPos = i;
            if(i*2<=n && a[i]<a[i*2]){ // 先与左子节点比较
                maxPos = i*2;
            }
            if(i*2+1<=n && a[maxPos]<a[i*2+1]){ // 再与右子节点比较
                maxPos = i*2+1;
            }
            if(maxPos==i){
                break;
            }
            swap(a,i,maxPos);
            i = maxPos;
        }
     }


    /**
     *
     * @param a
     * @param i 关注节点下标
     * @param pi 关注节点的父节点/子节点下标
     */
    public void swap(int[]a,int i,int pi){
        int j = a[i];
        a[i] = a[pi];
        a[pi] = j;
    }


    public String getA(){
        if(a.length>0){
            StringBuffer sbf = new StringBuffer();
            for(int a1:a){
                sbf.append(a1).append(" ");
            }
            return sbf.toString();
        }
        return null;
    }
}
