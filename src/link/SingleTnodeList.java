package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: SingleTnodeList
 * @Author: zwj
 * @Description: 注释 单向链表
 * @Date: 2019/10/16 15:14
 * @Version: 1.0
 */
public class SingleTnodeList<E> {

    transient int size = 0;
    transient TNode<E> first;
    transient TNode<E> last;
    public void add(E element){
        TNode<E> l = last; // 重点：这里没有创建新对象，只是加了新的对象引用
        TNode<E> newNode = new TNode<>(element,null);
        last = newNode;
        if(first == null){
            first = newNode;
        }else{
            l.next=newNode; // 原先对象的.next赋值newNode,这里的l是新的引用变量，但是内存对象没有变
        }
        size++;
        return;
    }
    public void list(){
        for (TNode<E> x = first; x != null; x = x.next) {
            System.out.println(x.data);
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
                return;
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
