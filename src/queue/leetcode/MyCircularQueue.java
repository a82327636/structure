package queue.leetcode;

/**
 * @ProjectName: structure
 * @Package: queue.leetcode
 * @ClassName: MyCircularQueue
 * @Author: zwj
 * @Description: 注释 双端循环队列
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularQueue(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularQueue circularDeque = new MyCircularQueue(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 * 提示：
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。

 *
 * @Date: 2019/10/18 14:33
 * @Version: 1.0
 */
public class MyCircularQueue {

    private int[]items;
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    /**
     * 使用循环数组来实现避免数据迁移，这里不预留多一位做队满的判断了，
     * 队满的条件需要总结规律怕忘了，直接记录size来做判断队列空还是满，需要注意的是在插入头部时，
     * 头部指针回退一位的处理；和删除尾部时，尾部指针回退一位的处理
     *
     * @param capacity
     */

    public MyCircularQueue(int capacity){
        this.items = new int[capacity];
        this.capacity = capacity;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            System.out.println("queue is full!");
            return false;
        }
        if(head-1<0){
            head = capacity-1;
        }else{
            head--;
        }
        items[head]=value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            System.out.println("queue is full!");
            return false;
        }
        items[tail]=value;
        tail = (tail+1)%capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            System.out.println("queue is empty!");
            return false;
        }
        head=(head+1)%capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            System.out.println("queue is empty!");
            return false;
        }
        if(tail - 1<0){
            tail = (tail+1)%capacity;
        }else{
            tail--;
        }
        size --;
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            System.out.println("queue is empty!");
            return -1;
        }
        int value = items[head];
        return value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            System.out.println("queue is empty!");
            return -1;
        }
        int value = items[tail-1];
        if(tail -1 <0){
            value = items[capacity-1];
        }
        return value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(size == capacity){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.print(1%10);
        System.out.print(2%10);
    }

}
