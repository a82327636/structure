package binarytree.leetcode;

/**
 * @ProjectName: structure
 * @Package: binarytree.leetcode
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/30 9:34
 * @Version: 1.0
 */
public class Main {

    // 1: 翻转二叉树
    // 2: 二叉树的最大深度
    // 3: 验证二叉查找树

    public static void main(String[] args) {

        // 1: 翻转二叉树
//        InvertTree invertTree = new InvertTree();
//        invertTree.insert(5);
//        invertTree.insert(1);
//        invertTree.insert(3);
//        invertTree.insert(7);
//        invertTree.insert(2);
//        invertTree.insert(8);
//        invertTree.insert(10);
//        invertTree.inorder();
//        System.out.println("#######");
//        invertTree.invertTree();
//        invertTree.inorder();

        // 2: 二叉树的最大深度
//        MaxDepth maxDepth = new MaxDepth();
//        maxDepth.insert(3);
//        maxDepth.insert(2);
//        maxDepth.insert(20);
//        maxDepth.insert(15);
//        maxDepth.insert(7);
//        System.out.println(maxDepth.maxDepth());
//        maxDepth.inorder();

        // 3: 验证二叉查找树
        IsValidBST isValidBST = new IsValidBST();
        IsValidBST.TreeNode treeNode5 = isValidBST.new TreeNode(5);
        IsValidBST.TreeNode treeNode1 = isValidBST.new TreeNode(1);
        IsValidBST.TreeNode treeNode4 = isValidBST.new TreeNode(4);
        IsValidBST.TreeNode treeNode3 = isValidBST.new TreeNode(3);
        IsValidBST.TreeNode treeNode6 = isValidBST.new TreeNode(6);
        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        System.out.println(isValidBST.isValidBST(treeNode5));
    }
}
