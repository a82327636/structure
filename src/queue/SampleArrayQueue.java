package queue;

/**
 * @ProjectName: structure
 * @Package: queue
 * @ClassName: SampleArrayQueue
 * @Author: zwj
 * @Description: 注释 数组实现队列 (有界队列使用数组实现)
 * @Date: 2019/10/18 10:33
 * @Version: 1.0
 */
public class SampleArrayQueue {


    private String[]arrays;
    private int n = 0; // 数组容量
    private int head = 0; // 头指针
    private int tail = 0; // 尾指针s

    public SampleArrayQueue(int arraysSize){
        arrays = new String[arraysSize];
        n = arraysSize;
    }

    // 简单入列
    public void enqueue(String item){
        if(n==tail){ // 表示队列已满
            System.out.println("queque is full !");
            return;
        }
        arrays[tail] = item;
        tail++;
    }

    // 需要做数据搬移
    public void enqueue_1(String item){
        if(n==tail){ // 表示队列已满
            if(head == 0){ // 表示队列真的满了
                System.out.println("queque is full !");
                return;
            }
            System.out.println("array space fit triggered!");
            for(int i = head;i<tail;++i){
                arrays[i-head] = arrays[i]; // 最妙的地方在这里,将数据整体前移
            }
            tail -= head;
            head = 0;
        }
        arrays[tail] = item;
        tail++;
    }

    public String dequeue(){
        if(head == tail){// 表示队列为空
            return "queue is empty!";
        }
        String value = arrays[head];
        head++;
        return value;
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
