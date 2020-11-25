package stack;

/**
 * @ProjectName: structure
 * @Package: stack
 * @ClassName: SampleLinkStack
 * @Author: zwj
 * @Description: 注释 基于链表的栈
 * @Date: 2019/10/17 15:34
 * @Version: 1.0
 */
public class SampleLinkStack<E extends Object> {


    transient Snode<E> top;

    public void push(E element){
        Snode<E>newSnode = new Snode<>(element,null);
        if(top == null){
            top = newSnode;
        }else{
            newSnode.next = top;
            top = newSnode;
        }
    }


    public int pop(){
        if (top == null) return -1;
        int value = (Integer)top.data;
        top = top.next;
        return value;
    }

    private static class Snode<E>{
        E data;
        Snode next;
        Snode(E data,Snode<E>next){
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Snode getNext() {
            return next;
        }

        public void setNext(Snode next) {
            this.next = next;
        }
    }
}
