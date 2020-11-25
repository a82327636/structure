package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: SingleTnodeList
 * @Author: zwj
 * @Description: 注释 单向链表反转
 * @Date: 2019/10/16 15:14
 * @Version: 1.0
 */
public class ReverseTnodeList<E> {

    transient int size = 0;
    transient ReverseTnode<E> first;
    transient ReverseTnode<E> last;

    public void add(E element){
        ReverseTnode<E> l = last; // 重点：这里没有创建新对象，只是加了新的对象引用
        ReverseTnode<E> newNode = new ReverseTnode<>(element,null);
        last = newNode;
        if(first == null){
            first = newNode;
        }else{
            l.next=newNode; // 原先对象的.next赋值newNode,这里的l是新的引用变量，但是内存对象没有变
        }
        size++;
        return;
    }

    public void reverse(){
        int count = size;
        ReverseTnode<E>currNode = first;
        ReverseTnode<E>prevNode = null;
        ReverseTnode<E>nextNode = null;
        while(count>0){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode=currNode;
            currNode = nextNode;
            count--;
        }
    }

    public void flist(){
        int count = size;
        ReverseTnode<E>currNode = first;
        while(count>0){
            System.out.println(currNode.data);
            currNode = currNode.next;
            count--;
        }
    }

    public void llist(){
        int count = size;
        ReverseTnode<E>currNode = last;
        while(count>0){
            System.out.println(currNode.data);
            currNode = currNode.next;
            count--;
        }
    }


}
