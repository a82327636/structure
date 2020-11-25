package binarytree.leetcode;

import java.util.LinkedList;

/**
 * @ProjectName: structure
 * @Package: binarytree.leetcode
 * @ClassName: IsValidBST
 * @Author: zwj
 * @Description: 注释 验证二叉查找树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4
 *
 * @Date: 2019/10/30 15:19
 * @Version: 1.0
 */
public class IsValidBST {


    // 递归 首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.data;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    /**
     * 方法二: 迭代
     * 通过使用栈，上面的递归法可以转化为迭代法。这里使用深度优先搜索，比广度优先搜索要快一些。
     */

    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST1(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            val = root.data;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    /**
     * 方法三 使用中序遍历 （保证i-1节点>i节点）如果不满足则说明不是有效二叉查找树
     */

    public class TreeNode{
        private int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }

}
