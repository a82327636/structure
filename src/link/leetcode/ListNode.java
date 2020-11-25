package link.leetcode;

/**
 * @ProjectName: structure
 * @Package: link.leetcode
 * @ClassName: ListNode
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/17 11:32
 * @Version: 1.0
 */
public class ListNode<E> {

    E data;
    ListNode<E> next;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }
}
