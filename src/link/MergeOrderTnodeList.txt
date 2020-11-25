package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: SingleTnodeList
 * @Author: zwj
 * @Description: 注释 合并有序单向链表
 * @Date: 2019/10/16 15:14
 * @Version: 1.0
 */
public class MergeOrderTnodeList<E> {

    transient int size = 0;
    public transient ReverseTnode<E> first;
    public transient ReverseTnode<E> last;

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

    public ReverseTnode merge(ReverseTnode<Integer> l1,ReverseTnode<Integer> l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.data < l2.data){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }

    }

    public void list(){
        for (ReverseTnode<E> x = first; x != null; x = x.next) {
            System.out.println(x.data);
        }
    }




}
