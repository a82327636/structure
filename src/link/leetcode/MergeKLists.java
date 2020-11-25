package link.leetcode;


import link.MergeOrderTnodeList;
import link.ReverseTnode;

/**
 * @ProjectName: structure
 * @Package: link.leetcode
 * @ClassName: MergeKLists
 * @Author: zwj
 * @Description: 注释 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 *
 * @Date: 2019/10/17 11:43
 * @Version: 1.0
 */
public class MergeKLists<E> {


    public static void main(String[] args) {
        MergeOrderTnodeList mergeOrderTnodeList1 = new MergeOrderTnodeList();
        mergeOrderTnodeList1.add(1);
        mergeOrderTnodeList1.add(4);
        mergeOrderTnodeList1.add(5);
        MergeOrderTnodeList mergeOrderTnodeList2 = new MergeOrderTnodeList();
        mergeOrderTnodeList2.add(1);
        mergeOrderTnodeList2.add(3);
        mergeOrderTnodeList2.add(4);
        MergeOrderTnodeList mergeOrderTnodeList3 = new MergeOrderTnodeList();
        mergeOrderTnodeList3.add(2);
        mergeOrderTnodeList3.add(6);
        MergeOrderTnodeList mergeOrderTnodeList4 = new MergeOrderTnodeList();
        ReverseTnode reverseTnode = mergeOrderTnodeList4.merge(mergeOrderTnodeList4.merge(mergeOrderTnodeList1.first,mergeOrderTnodeList2.first),mergeOrderTnodeList3.first);
        while(reverseTnode!=null){
            System.out.println(reverseTnode.data);
            reverseTnode = reverseTnode.next;
        }
    }


    /**
     * 将 k 个链表配对两两链表合并。
     * 重复这一过程，直到我们得到了最终的有序链表。
     */
    public ReverseTnode merge(ReverseTnode<Integer> l1, ReverseTnode<Integer> l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.getData() < l2.getData()){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }

    }

}
