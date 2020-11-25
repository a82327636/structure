package hash;

import java.util.HashMap;

/**
 * @ProjectName: structure
 * @Package: hash
 * @ClassName: LRUHashTable
 * @Author: zwj
 * @Description: 注释 LRU缓存散列表
 * @Date: 2019/10/28 11:42
 * @Version: 1.0
 */
public class LRUHashTable<K,V> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private DNode<K, V> headNode;

    /**
     * 尾节点
     */
    private DNode<K, V> tailNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    /**
     * 散列表存储key
     */
    private HashMap<K, DNode<K, V>> table;


    public LRUHashTable(int capacity) {
        this.length = 0;
        this.capacity = capacity;

        headNode = new DNode<>(); // 使用了哨兵机制，首节点和尾节点一直为空

        tailNode = new DNode<>();

        headNode.next = tailNode;
        tailNode.prev = headNode;

        table = new HashMap<>();
    }

    public LRUHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 新增
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            DNode<K, V> newNode = new DNode<>(key, value);
            table.put(key, newNode);
            addNode(newNode);

            if (++length > capacity) {
                DNode<K, V> tail = popTail();
                table.remove(tail.key);
                length--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将新节点加到头部
     *
     * @param newNode
     */
    private void addNode(DNode<K, V> newNode) {
        newNode.next = headNode.next; // 1:将新节点的下个节点设置为tailNode
        newNode.prev = headNode;  // 2:将新节点的上个节点设置为headNode

        headNode.next.prev = newNode; // 3:将之前headNode的下个节点的前驱节点设置为新节点
        headNode.next = newNode; //4:将之前headNode的下个节点设置为新节点
    }

    /**
     * 弹出尾部数据节点
     */
    private DNode<K, V> popTail() {
        DNode<K, V> node = tailNode.prev;
        removeNode(node);
        return node;
    }

    /**
     * 移除节点
     *
     * @param node
     */
    private void removeNode(DNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点移动到头部
     *
     * @param node
     */
    private void moveToHead(DNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 获取节点数据
     *
     * @param key
     * @return
     */
    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 移除节点数据
     *
     * @param key
     */
    public void remove(K key) {
        DNode<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        length--;
    }

    public void printAll() {
        DNode<K, V> node = headNode.next;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 双向链表
     */
    static class DNode<K, V> {

        private K key;

        /**
         * 数据
         */
        private V value;

        /**
         * 前驱指针
         */
        private DNode<K, V> prev;

        /**
         * 后继指针
         */
        private DNode<K, V> next;

        DNode() {
        }

        DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
