package hash;

/**
 * @ProjectName: structure
 * @Package: hash
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/24 15:35
 * @Version: 1.0
 */
public class Main {

    // 1: 实现一个基于链表法解决冲突问题的散列表
    // 2: 实现一个LRU缓存淘汰算法

    public static void main(String[] args) {

        // 跳表
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(5);
        skipList.insert(9);
        skipList.insert(13);
        skipList.printAll();
//        skipList.delete(3);
//        skipList.printAll();
        System.out.println(skipList.find(5));


        // 1: 实现一个基于链表法解决冲突问题的散列表
//        HashLinkMap<Integer,String> hashLinkMap = new HashLinkMap(HashLink.class,5);
//        hashLinkMap.put(1,"a");
////        hashLinkMap.put(2,"b");
////        hashLinkMap.put(3,"c");
////        hashLinkMap.put(4,"d");
////        hashLinkMap.put(5,"e");
//        hashLinkMap.put(6,"f");
//        System.out.println(hashLinkMap.get(1)+","+hashLinkMap.get(2)+","+hashLinkMap.get(3)
//                +","+hashLinkMap.get(4)+","+hashLinkMap.get(5)+","+hashLinkMap.get(6));

        // 2: 实现一个LRU缓存淘汰算法
//        LRUHashTable lruHashTable = new LRUHashTable(5);
//        lruHashTable.add(1,"a");
//        lruHashTable.add(2,"b");
//        lruHashTable.printAll();
    }
}
