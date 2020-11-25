package queue;

/**
 * @ProjectName: structure
 * @Package: queue
 * @ClassName: SampleLinkQurere
 * @Author: zwj
 * @Description: 注释 链表实现队列(无界队列使用链表实现)
 * @Date: 2019/10/18 10:56
 * @Version: 1.0
 */
public class SampleLinkQueue {

    transient Qnode head = null;
    transient Qnode tail = null;


    public void enqueue(String item){
        Qnode lQnode = tail;
        Qnode newQnode = new Qnode(item,null);
        tail = newQnode;
        if(head == null){
             head = newQnode;
        }else{
            lQnode.next = newQnode;
        }

    }

    public String dequeue(){
        if(head == null) return "queue is empty!";
        String value = head.data;
        head = head.next;
        if (head == null) { // 下一个值可能为空
            tail = null;
        }
        return value;
    }





    private static class Qnode{
        String data;
        Qnode next;
        public Qnode(String data,Qnode next){
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Qnode getNext() {
            return next;
        }

        public void setNext(Qnode next) {
            this.next = next;
        }
    }
}
