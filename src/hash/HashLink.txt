package hash;

/**
 * @ProjectName: structure
 * @Package: hash
 * @ClassName: HashLink
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/28 10:52
 * @Version: 1.0
 */
public class HashLink<K,V>{

    private Hnode first; // 链表首节点

    // get()方法
    public V get(K key) {
        for(Hnode node = first; node != null; node = node.next){
            if(key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }

    // put()方法
    public void put(K key, V value) {
        // 先查找表中是否已经存在相应的key
        Hnode node;
        for(node = first; node != null; node = node.next){
            if(node.value.equals(key)){
                node.value = value;  // 如果key存在，就把当前value修改
                return;
            }
        }
        if(first!=null){
            // 如果不存在，则插入node.next中
            Hnode nNode = new Hnode(key, value, first);
            first = nNode;
        }else{
            // 表中不存在相应的key，直接插入表头
            first = new Hnode(key, value, first);
        }

    }

    private class Hnode{

        private K key;
        private V value;
        private Hnode next;

        public Hnode(K key,V value,Hnode next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Hnode getNext() {
            return next;
        }

        public void setNext(Hnode next) {
            this.next = next;
        }

    }
}
