package link;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: DoubleTnodeList
 * @Author: zwj
 * @Description: 注释 双向链表
 * @Date: 2019/10/16 15:40
 * @Version: 1.0
 */
public class DoubleTnodeList<E> {


    transient int size = 0;
    transient TNode<E> first;
    transient TNode<E> last;

    public void add(E element){
        TNode<E> l = last; // 重点：这里没有创建新对象，只是加了新的对象引用
        TNode<E> newNode = new TNode<>(element,l,null);
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
        int count = size;
        TNode<E>tNode =first;
        while(count>0){
            System.out.println(tNode.data);
            tNode = tNode.next;
            count --;
        }
    }

    public void get(E element){
        int count = size;
        TNode<E>tNode =first;
        while(count>0){
            if(tNode.data == element){
                System.out.println("data: "+tNode.data);
                if(tNode.prev!=null){
                    System.out.println("prev: "+tNode.prev.data);
                }
                if(tNode.next!=null){
                    System.out.println("next: "+tNode.next.data);
                }
            }
            tNode = tNode.next;
            count --;
        }
    }

    public void remove(E element){
        TNode<E> target = first;
        int count = size;
        if(element.equals(target.data)){
            TNode<E> node = first;
            first = first.next;
            size--;
        }else{
            while(count>0){
                if(element.equals(target.data)){
                    target.prev.next = target.next;
                    target.next.prev = target.prev;
                    size--;
                    break;
                }
                count --;
                target = target.next;
            }
        }
    }


    private static class TNode<E>{
        E data;
        TNode<E> prev;
        TNode<E> next;
        TNode(E data,TNode<E> prev,TNode<E> next){
            this.data = data;
            this.prev = prev;
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

        public TNode<E> getPrev() {
            return prev;
        }

        public void setPrev(TNode<E> prev) {
            this.prev = prev;
        }
    }
}
