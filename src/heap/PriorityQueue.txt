package heap;

/**
 * @ProjectName: structure
 * @Package: heap
 * @ClassName: PriorityQueue
 * @Author: zwj
 * @Description: 注释 优先级队列
 *
 * @Date: 2019/10/31 11:42
 * @Version: 1.0
 */
public class PriorityQueue {


    private int[]a; // 数组从下标1开始
    private int n;//堆可以存储的最大数据个数
    private int count; // 堆中已存在的数据个数

    public PriorityQueue(int capacity){
        a = new int[capacity+1];
        n = capacity;
        count = 0;
    }


    public void enqueue(int data){
        if(count>=n)return; // 堆满了
        ++count;
        a[count]=data;
        int i = count;
        while(i/2 > 0 && a[i]<a[i/2]){ // 自下往上堆化,父节点下标=节点下标/2
            swap(a,i,i/2);// swap()函数的作用，交换下标为i和i/2的两个元素
            i = i/2;
        }
    }


    public int dequeue(){
        if(count == 0)return -1; // 堆中没有元素
        int value = a[1];
        a[1] = a[count]; // 删除对顶，将堆尾放入对顶的位置
        a[count] = 0;
        --count;
        heapify(a,count,1); //开始堆化，要满足堆的两种规定
        return value;
    }


    private void heapify(int[]a,int n,int i){ // 自上往下堆化
        while(true){
            int maxPos = i;
            if(i*2<=n && a[i]>a[i*2]){ // 先与左子节点比较
                maxPos = i*2;
            }
            if(i*2+1<=n && a[maxPos]>a[i*2+1]){ // 再与右子节点比较
                maxPos = i*2+1;
            }
            if(maxPos==i){
                break;
            }
            swap(a,i,maxPos);
            i = maxPos;
        }
    }


    public void swap(int[]a,int i,int pi){
        int j = a[i];
        a[i] = a[pi];
        a[pi] = j;
    }



}
