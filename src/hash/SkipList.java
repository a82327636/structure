package hash;

import java.util.Random;

/**
 * @ProjectName: structure
 * @Package: hash
 * @ClassName: SkipList
 * @Author: zwj
 * @Description: 注释 跳表
 * @Date: 2019/10/25 15:47
 * @Version: 1.0
 */
public class SkipList {

    /***
     * 核心
     * 1:每次插入新的数据时候随机产生level,决定新节点索引层数(原链表是0层)
     * 2:数组update的作用：用于存储新节点所有索引层数，各自前一个节点的信息
     * 3:节点内forwards数组: 用以存储该节点所有层的下一节点的信息。
     *
     * 4:当所有节点的最大层级变量maxlevel==1时，跳表退化成一个普通链表
     * */

    private static final int MAX_LEVEL = 16; // 设置最大层级

    private int levelCount = 1;

    private Node head = new Node();  // 带头链表

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel(); // 每次插入数据是随机生成level，决定新节点层数
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level]; // 用于存储新节点所有索引层数
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head; // 只能得到一个索引层的值
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i]; //
            }
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i]; // // forwards 用以存储该节点所有层的下一节点的信息
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

        while (levelCount>1&&head.forwards[levelCount]==null){
            levelCount--;
        }

    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL]; // 存储该节点所有索引层的下一跳
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
