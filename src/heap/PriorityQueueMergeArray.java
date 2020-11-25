package heap;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: structure
 * @Package: heap
 * @ClassName: PriorityQueueMergeArray
 * @Author: zwj
 * @Description: 注释 优先级队列合并数组
 * @Date: 2019/10/31 15:08
 * @Version: 1.0
 */
public class PriorityQueueMergeArray {

    private int[] arrays; // 最后的有序数组
    private int count;//数组下标
    public PriorityQueueMergeArray(int capacity){
        arrays = new int[capacity];
        count = 0;
    }


    public void execute(){
        int[]arrays1 = new int[]{1,3,5,7,9};
        int[]arrays2 = new int[]{2,4,6,8,10};
        int[]arrays3 = new int[]{3,8,10,11,13};
        int[][]arrays = new int[][]{arrays1,arrays2,arrays3};
        // 优先级队列初始值
        PriorityQueue priorityQueue = new PriorityQueue(3);
        main(priorityQueue,arrays[0][0],arrays[1][0],arrays[2][0]);
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        while(count<=14){
            int value = priorityQueue.dequeue();
            add(value);
            if(len1< arrays1.length-1 && value == arrays[0][len1]){
                priorityQueue.enqueue(arrays[0][++len1]);
            }else if(len2< arrays1.length-1 && value == arrays[1][len2]){
                priorityQueue.enqueue(arrays[1][++len2]);
            }else if( len3< arrays1.length-1 && value == arrays[2][len3]){
                priorityQueue.enqueue(arrays[2][++len3]);
            }
        }
    }


    public void main(PriorityQueue priorityQueue,int array1,int array2,int array3){
        priorityQueue.enqueue(array1);
        priorityQueue.enqueue(array2);
        priorityQueue.enqueue(array3);
    }


    public void add(int data){
        arrays[count] = data;
        count++;
    }

    public void printAll(){
        StringBuffer sbf = new StringBuffer();
        for(int array:arrays){
            sbf.append(array).append(" ");
        }
        System.out.println(sbf.toString());
    }
}
