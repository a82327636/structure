package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: MiddleTnodeList
 * @Author: zwj
 * @Description: 注释 求中间节点
 * @Date: 2019/10/17 9:54
 * @Version: 1.0
 */
public class MiddleTnodeList<E> {

    // 思路1（针对奇数结点）：使用两条链表向后移动，第一条先走两步，然后第二条开始走，
    // 当第一条到尾巴时，第二条所到的结点就是中间结点。

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

    public void getMiddleNode(ReverseTnode r1,ReverseTnode r2){
        if(r1 == null){
            System.out.println("1middle node is :"+r2.data);
            return;
        }
        if(r1.next == null){
            System.out.println("2middle node is :"+r2.data);
            return;
        }

        getMiddleNode(r1.next.next,r2.next);

    }

}
