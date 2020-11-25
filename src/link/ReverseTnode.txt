package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: ReverseNode
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/16 17:00
 * @Version: 1.0
 */
public class ReverseTnode<E> {

    public E data;
    public ReverseTnode<E> next;
    ReverseTnode(E data, ReverseTnode<E> next){
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ReverseTnode<E> getNext() {
        return next;
    }

    public void setNext(ReverseTnode<E> next) {
        this.next = next;
    }
}
