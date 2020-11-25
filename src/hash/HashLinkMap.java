package hash;


import java.lang.reflect.Array;

/**
 * @ProjectName: structure
 * @Package: hash
 * @ClassName: HashLinkMap
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/28 10:44
 * @Version: 1.0
 */
public class HashLinkMap<K,V> {

    private int capacity;  			// 散列表的大小
    private HashLink<K, V>[] st;   // 链表对象数组 (每一个hash值，对应一个链表)

    // 构造函数
    public <T> HashLinkMap(Class<T> type,int initialCapacity){
        capacity = initialCapacity;
        st = (HashLink<K, V>[])(Array.newInstance(type, capacity));
        //st = (HashLink<K, V>[]) new Object[capacity]; // 会出现object转换HashLink异常
        for(int i = 0; i < capacity; i++){
            st[i] = new HashLink<>();
        }
    }

    // hash()方法
    // & 0x7fffffff是最大的整型数，0111 1111 1111 1111 1111 1111 1111 1111
    //  （前31一个1代表数值，在计算机中整型最高位（32位）是符号位 0代表正数，1代表负数）
    // hash与其按位与得到一个正数  (为什么要& 0x7fffffff？ 主要是为了保证得到第一位为0，也就是为了得到一个正数)
    // 首先java int 类型可以表示的范围是[-2^31,2^31-1]
    // java中的int类型存储长度为32bit，符号位占了1个bit ，所以可以用来表示int的数目的范围是31位
    private int hash(K key){
            return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public V get(K key){
        return st[hash(key)].get(key);
    }

    public void put(K key, V value) {
        st[hash(key)].put(key, value);
    }

}
