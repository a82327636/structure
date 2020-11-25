package link;

/**
 * @ProjectName: structure
 * @Package: link
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/16 10:53
 * @Version: 1.0
 */
public class Main {

    // 1:实现单链表、循环链表、双向链表、支持增删操作。
    // 2:实现单链表反转
    // 3:实现两个有序的链表合并为一个有序链表
    // 4:实现求链表的中间结点


    public static void main(String[] args) {
        // 单链表
//        SingleTnodeList singetTnodeList = new SingleTnodeList();
//        singetTnodeList.add(1);
//        singetTnodeList.add(2);
//        singetTnodeList.add(3);
//        singetTnodeList.add(4);
//        singetTnodeList.add(5);
//        singetTnodeList.list();
//        singetTnodeList.remove(5);
//        System.out.println("*****************");
//        singetTnodeList.list();

        // 循环链表
        CircleTnodeList circleTnodeList = new CircleTnodeList();
        circleTnodeList.add(1);
        circleTnodeList.add(2);
        circleTnodeList.add(3);
        circleTnodeList.add(4);
        circleTnodeList.add(5);
        circleTnodeList.list();
        circleTnodeList.remove(4);
        circleTnodeList.list();

        // 双向链表
//        DoubleTnodeList doubleTnodeList = new DoubleTnodeList();
//        doubleTnodeList.add(1);
//        doubleTnodeList.add(2);
//        doubleTnodeList.add(3);
//        doubleTnodeList.add(4);
//        doubleTnodeList.add(5);
//        doubleTnodeList.list();
//        System.out.println("**************");
//        doubleTnodeList.remove(4);
//        doubleTnodeList.get(5);
//        System.out.println("**************");
//        doubleTnodeList.list();

        // 单链表反转
//        ReverseTnodeList reverseTnodeList = new ReverseTnodeList();
//        reverseTnodeList.add(1);
//        reverseTnodeList.add(2);
//        reverseTnodeList.add(3);
//        reverseTnodeList.add(4);
//        reverseTnodeList.add(5);
//        reverseTnodeList.flist();
//        System.out.println("**************");
//        reverseTnodeList.reverse();
//        reverseTnodeList.llist();

        // 实现两个有序的链表合并为一个有序链表
//        MergeOrderTnodeList mergeOrderTnodeList1 = new MergeOrderTnodeList();
//        mergeOrderTnodeList1.add(1);
//        mergeOrderTnodeList1.add(3);
//        mergeOrderTnodeList1.add(5);
//        MergeOrderTnodeList mergeOrderTnodeList2 = new MergeOrderTnodeList();
//        mergeOrderTnodeList2.add(2);
//        mergeOrderTnodeList2.add(4);
//        mergeOrderTnodeList2.add(6);
//        MergeOrderTnodeList mergeOrderTnodeList3 = new MergeOrderTnodeList();
//        ReverseTnode reverseTnode = mergeOrderTnodeList3.merge(mergeOrderTnodeList1.first,mergeOrderTnodeList2.first);
//        while(reverseTnode!=null){
//            System.out.println(reverseTnode.data);
//            reverseTnode = reverseTnode.next;
//        }

        // 求中间节点
//        MiddleTnodeList middleTnodeList1 = new MiddleTnodeList();
//        middleTnodeList1.add(1);
//        middleTnodeList1.add(2);
//        middleTnodeList1.add(3);
//        middleTnodeList1.add(4);
//        middleTnodeList1.add(5);
//        middleTnodeList1.add(6);
//        middleTnodeList1.add(7);
//        middleTnodeList1.add(8);
//
//        MiddleTnodeList middleTnodeList2 = new MiddleTnodeList();
//        middleTnodeList2.add(1);
//        middleTnodeList2.add(2);
//        middleTnodeList2.add(3);
//        middleTnodeList2.add(4);
//        middleTnodeList2.add(5);
//        middleTnodeList2.add(6);
//        middleTnodeList2.add(7);
//        middleTnodeList2.add(8);
//
//        MiddleTnodeList middleTnodeList3 = new MiddleTnodeList();
//        middleTnodeList3.getMiddleNode(middleTnodeList1.first,middleTnodeList2.first);

    }
}
