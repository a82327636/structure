package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: TrieNode
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/29 14:08
 * @Version: 1.0
 */
public class TrieNode {
    char data;
    TrieNode children[]; // 0~25对应a~z
    boolean isEndingChar = false; // 是否叶子节点
    public TrieNode(char data){
        this.data = data;
        children = new TrieNode[26];
    }
}
