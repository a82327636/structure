package binarytree;

/**
 * @ProjectName: structure
 * @Package: binarytree
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 二叉树
 * @Date: 2019/10/30 9:30
 * @Version: 1.0
 */
public class Main {

    // 1:实现一个二叉查找树,并且支持插入、删除、查找操作
    // 2:实现查找二叉树中某个节点的后继、前驱节点
    // 3:实现二叉树前、中、后序以及按层遍历


    public static void main(String[] args) {

        // 1:实现一个二叉查找树,并且支持插入、删除、查找操作
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(10);
        System.out.println(binarySearchTree.find(7));
        binarySearchTree.delete(7);
        System.out.println(binarySearchTree.find(7));

        // 2:实现查找二叉树中某个节点的后继、前驱节点
//        System.out.println(binarySearchTree.getPreNode(binarySearchTree.find(3)));
//        System.out.println(binarySearchTree.getPostNode(binarySearchTree.find(3)));

        // 3:实现二叉树前、中、后序以及按层遍历
        binarySearchTree.inorder(binarySearchTree.find(5));
//        binarySearchTree.inorder(binarySearchTree.find(3));
//        binarySearchTree.postorder(binarySearchTree.find(3));
    }

}
