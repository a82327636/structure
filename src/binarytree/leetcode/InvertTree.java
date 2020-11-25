package binarytree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: binarytree.leetcode
 * @ClassName: InvertTree
 * @Author: zwj
 * @Description: 注释 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * @Date: 2019/10/30 14:48
 * @Version: 1.0
 */
public class InvertTree {

    private TreeNode tree;

    public TreeNode invertTree(){
        return invertTree(tree);
    }

    // 本方法使用了递归，在最坏情况下栈内需要存放 O(h)O(h) 个方法调用，其中 hh 是树的高度
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    // 用迭代方法来解决这个问题，这种做法和深度优先搜索（Breadth-fist Search, BFS）很接近
    // 这个方法的思路就是，我们需要交换树中所有节点的左孩子和右孩子。
    // 因此可以创一个队列来存储所有左孩子和右孩子还没有被交换过的节点。
    // 开始的时候，只有根节点在这个队列里面。
    // 只要这个队列不空，就一直从队列中出队节点，然后互换这个节点的左右孩子节点，接着再把孩子节点入队到队列，
    // 对于其中的空节点不需要加入队列。最终队列一定会空，这时候所有节点的孩子节点都被互换过了，直接返回最初的根节点就可以了
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



    public void insert(int data){
        if(tree == null){
            tree = new TreeNode(data);
            return;
        }
        TreeNode p = tree;
        while(p!=null){
            if(data>p.data){
                if(p.right==null){
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            }else{ // data<=p.data
                if(p.left==null){
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
        return;
    }

    void inorder(){
        inorder(tree);
    }

    //递归中序遍历
    void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }

}
