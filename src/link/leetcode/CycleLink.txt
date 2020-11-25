package link.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: structure
 * @Package: link.leetcode
 * @ClassName: CycleLink
 * @Author: zwj
 * @Description: 注释 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
 * @Date: 2019/10/17 11:26
 * @Version: 1.0
 */
public class CycleLink {


    public static void main(String[] args) {
//        ListNode listNode4 = new ListNode();
////        listNode4.data = 4;
////
////        ListNode listNode3 = new ListNode();
////        listNode3.data = 3;
////        listNode3.next = listNode4;
////        ListNode listNode2 = new ListNode();
////        listNode2.data = 2;
////        listNode2.next = listNode3;
////        ListNode listNode1 = new ListNode();
////        listNode1.data = 1;
////        listNode1.next = listNode2;
////        listNode4.next = null; // 可以将尾结点的下个结点做设置
////
////        System.out.println(hasCycle(listNode1));
////        System.out.println(hasCycle1(listNode1));

    }

    /**
     * 方法一：哈希表
     *
     * 我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     *
     * 时间复杂度：O(n)，对于含有 n 个元素的链表，我们访问每个元素最多一次。
     * 添加一个结点到哈希表中只需要花费 O(1) 的时间。
     *
     * 空间复杂度：O(n)，空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素。
     *
     */


    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 方法二：双指针
     * 思路
     *
     * 想象一下，两名运动员以不同的速度在环形赛道上跑步会发生什么？
     *
     * 算法
     *
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)
     * 。慢指针每次移动一步，而快指针每次移动两步。
     *
     * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
     *
     * 现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。
     * 而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）- 假如快跑者只落后慢跑者一步，
     * 在下一次迭代中，它们就会分别跑了一步或两步并相遇。
     *
     * 其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。但其实不难想到，
     * 因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。

     */

    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
