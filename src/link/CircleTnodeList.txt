package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: CircleTnodeList
 * @Author: zwj
 * @Description: 注释 循环链表
 * @Date: 2019/10/16 15:14
 * @Version: 1.0
 */
public class CircleTnodeList<E> {

    transient int size = 0;
    transient TNode<E> first;
    transient TNode<E> last;

    public void add(E element){
        TNode<E> l = last;
        TNode<E> newNode = new TNode<>(element,first); // 关键点在于 新加的结点默认值是first
        last = newNode;
        if(first == null){
            first = newNode;
        }else{
            l.next=newNode;
        }
        size++;
        return;
    }
    public void list(){
        // 会循环输出
//        for (TNode<E> x = first; x != null; x = x.next) {
//            System.out.println(x.data);
//        }
        int count = size;
        TNode<E>tNode = first;
        while(count>0){
            System.out.println(tNode.data);
            tNode = tNode.next;
            count--;
        }
    }

    public void remove(E element){
        if(element == first.data){
            first = first.next;
            size--;
            return;
        }
        TNode<E> tNode = first;
        TNode<E> preNode = first;
        for (TNode<E> x = first; x != null; x = x.next) { // 注意区别于 while(tNode.next !=null)
            if(element == tNode.data){
                preNode.next = preNode.next.next;
                size--;
                break;
            }else{
                preNode = tNode;
                tNode = tNode.next; //循环取值
            }
        }
    }

    private static class TNode<E>{
        E data;
        TNode<E> next;
        TNode(E data, TNode<E> next){
            this.data = data;
            this.next = next;
        }
        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public TNode<E> getNext() {
            return next;
        }

        public void setNext(TNode<E> next) {
            this.next = next;
        }
    }
}
