package binarytree;

/**
 * @ProjectName: structure
 * @Package: binarytree
 * @ClassName: BinarySearchTree
 * @Author: zwj
 * @Description: 注释 二叉查找树
 *
 * 二叉查找树最大特点是：任意节点的左子节点小于它，右子节点大于它
 *
 * @Date: 2019/10/30 9:37
 * @Version: 1.0
 */
public class BinarySearchTree {


    private Bnode tree;

    public Bnode find(int data){
        Bnode p = tree;
        while(p!=null){
            if(data<p.data){
                p = p.left;
            }else if(data>p.data){
                p=p.right;
            }else{
                return p;
            }
        }
        return null;
    }


    public void insert(int data){
        if(tree == null){
            tree = new Bnode(data);
            return;
        }
        Bnode p = tree;
        while(p!=null){
            if(data>p.data){
                if(p.right==null){
                    p.right = new Bnode(data);
                    p.right.parent = p;
                    return;
                }
                p = p.right;
            }else{ // data<=p.data
                if(p.left==null){
                    p.left = new Bnode(data);
                    p.left.parent = p;
                    return;
                }
                p = p.left;
            }
        }
        return;
    }


    // 删除节点的三种情况
    // 1: 要删除的节点没有子节点，只需要直接将父节点指向要删除节点的指针为null
    // 2: 要删除的节点只有一个子节点,我们只需要更新父节点中，指向要删除节点的指针，让它指向删除节点的子节点.
    // 3: 要删除的节点有两个子节点，我们需要找到这个节点右子树中的最小节点(一定在左子树上)，
    //    把它替换到要删除的节点上，然后再删掉这个最小节点
    //    因为最小节点肯定没有左子节点

    public void delete(int data){
        Bnode p = tree; // p指向要删除的节点,初始化指向根节点
        Bnode pp = null; // pp记录的是p的父节点
        while(p !=null && p.data!=data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
          }
            if(p == null) return; // 没有找到

            // 要删除节点有两个子节点的情况
            if(p.left!=null && p.right !=null){ // 查找右子树中最小节点
                Bnode minP = p.right;
                Bnode minPP = p;// minPP 表示 minP的父节点
                while(minP.left !=null){ // 如果发现左节点为null,说明找到了最小节点
                    minPP = minP;
                    minP = minP.left;
                }
                p.data = minP.data; // 将minP的数据替换到P中
                p = minP; // 下面就变成删除minP
                pp = minPP;
            }

            // 有删除节点是叶子节点或者只有一个节点
            Bnode child;// p的子节点
            if(p.left!=null){
                child = p.left;
            }else if(p.right != null){
                child = p.right;
            }else{
                child = null;
            }
            if(pp == null){
                tree = child; // 删除的是根节点
            }else if(pp.left == p){
                pp.left = child;
            }else{
                pp.right = child;
            }
    }

    // 查找最小节点
    public Bnode findMin() {
        if (tree == null) return null;
        Bnode p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    // 查找最大节点
    public Bnode findMax() {
        if (tree == null) return null;
        Bnode p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 前驱节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的前一个节点为该节点的前驱节点；
     *
     * 后继节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的后一个节点为该节点的后继节点；
     *
     * 例如一颗完全二叉树（1,2,3,4,5,6,7），按照中序遍历后的顺序为：（4,2,5,1,6,3,7），1节点的前驱节点为：5，后继节点为6

     */

    // 查找前驱节点(中序遍历) // 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树
    // 如中序遍历后的值为 4-2-5-1-6-3-7
    public Bnode getPreNode(Bnode root) { // 获取前驱节点
        if (root == null)
            return root;
        if (root.left != null) {//如果其左子树存在，则返回其左子树的最右边节点
            return leftTreeMostRight(root.left);
        }
        else {
            //若果其左子树不存在，则向父节点寻找，满足当前节点是父节点的右孩子节点即可，
            // 否则向上更新当前节点和其父节点
            Bnode father = root.parent;
            while (father.right != root && father != null) {
                root = father;
                father = root.parent;
            }
            return father;//如果找到了就是满足father.right == root，如果没找到，则fathe指向NULL
        }
    }

    // 若该节点存在左子树，则其前驱节点为左子树最右边的节点
    public Bnode leftTreeMostRight(Bnode p) {
        while (p != null){
            p = p.right;
        }
        return p.parent;
    }


    // 查找后继节点(中序遍历)
    Bnode getPostNode(Bnode root) {
        if (root == null)
            return root;
        if (root.right != null) {//如果其右子树存在，则返回其右子树的最左边节点
            return getRightTreeMostLeft(root.right);
        }
        else {//若果其右子树不存在，则向父节点寻找，满足当前节点是父节点的左节点即可,否则向上更新当前节点和其父节点
            Bnode father = root.parent;
            while (father != null && root != father.left) {
                root = root.parent;
                father = root.parent;
            }
            return father;
        }
    }
    Bnode getRightTreeMostLeft(Bnode p) {
        while (p != null)
            p = p.left;
        return p.parent;
    }



    //递归前序遍历 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树
    public void preorder(Bnode root){
        if(root!=null){
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }


    //递归中序遍历
    void inorder(Bnode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }


    //递归后序遍历  后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点
    void postorder(Bnode root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    public static class Bnode{
        private int data;
        private Bnode left;
        private Bnode right;
        private Bnode parent; // 父节点
        public Bnode(int data){
            this.data = data;
        }
    }
}
