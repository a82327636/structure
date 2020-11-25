package queue;

/**
 * @ProjectName: structure
 * @Package: queue
 * @ClassName: SampleCircleQueue
 * @Author: zwj
 * @Description: 注释 循环队列(针对数组实现的队列，存在数据搬移[对头出列时]的情况而提出的)
 * @Date: 2019/10/18 10:57
 * @Version: 1.0
 */
public class SampleCircleQueue {

    private String[]arrays;
    private int n = 0;
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针

    public SampleCircleQueue(int capacity){
        arrays = new String[capacity];
        n = capacity;
    }

    public void enqueue(String item){
        if((tail+1)%n == head) {System.out.println("queue is full!");return;}
        arrays[tail] = item;
        tail = (tail+1)%n;
    }

    public String dequeue(){
        if(tail == head)return "queue is empty!";
        String value =arrays[head];
        head = (head+1) % n;
        return value;
    }

    public static void main(String[] args) {
        System.out.println(12%8);
    }
}
