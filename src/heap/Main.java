package heap;

/**
 * @ProjectName: structure
 * @Package: heap
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 堆
 * @Date: 2019/10/30 9:31
 * @Version: 1.0
 */
public class Main {

    // 1: 实现一个小顶堆、大顶堆、优先级队列
    // 2: 实现堆排序
    // 3: 利用优先级队列合并K个有序数组
    // 4: 求一组动态数据集合的最大Top K


    public static void main(String[] args) {

        // 1.1 实现一个大顶堆
        BigCapHeap bigCapHeap = new BigCapHeap(16);
        bigCapHeap.insert(1);
        bigCapHeap.insert(3);
        bigCapHeap.insert(5);
        bigCapHeap.insert(7);
        bigCapHeap.insert(2);
        bigCapHeap.insert(4);
        bigCapHeap.insert(6);
        System.out.println(bigCapHeap.getA());
        bigCapHeap.remvoeMax();
        System.out.println(bigCapHeap.getA());
        bigCapHeap.remvoeMax();
        System.out.println(bigCapHeap.getA());

        // 2: 实现堆排序
//        SortHeap sortHeap = new SortHeap();
//        int[]a = new int[]{0,9,6,3,1,5};
//       // sortHeap.buildHeap(a,5);
//        sortHeap.sort(a,5);
//        for(int a1:a){
//            System.out.println(a1);
//        }


        // 1.3 实现优先级队列 (小顶堆)
//        PriorityQueue priorityQueue = new PriorityQueue(5);
//        priorityQueue.enqueue(1);
//        priorityQueue.enqueue(7);
//        priorityQueue.enqueue(9);
//        priorityQueue.enqueue(5);
//        int i=5;
//        while(i>=0){
//            System.out.println(priorityQueue.dequeue());
//            i--;
//        }

        // 3: 利用优先级队列合并K个有序数组
//        PriorityQueueMergeArray priorityQueueMergeArray = new PriorityQueueMergeArray(15);
//        priorityQueueMergeArray.execute();
//        priorityQueueMergeArray.printAll();
    }






}
