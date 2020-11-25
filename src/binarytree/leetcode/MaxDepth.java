package binarytree.leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: structure
 * @Package: binarytree.leetcode
 * @ClassName: MaxDepth
 * @Author: zwj
 * @Description: 注释 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。

 *
 * @Date: 2019/10/30 15:05
 * @Version: 1.0
 */
public class MaxDepth {

    private TreeNode tree;

    public int maxDepth(){
        return maxDepth(tree);
    }

    // 直观的方法是通过递归来解决问题。在这里，我们演示了 DFS（深度优先搜索）策略的示例
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    // 我们还可以在栈的帮助下将上面的递归转换为迭代。
    //我们的想法是使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
    //所以我们从包含根结点且相应深度为 1 的栈开始。然后我们继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
    public int maxDepth1(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
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
