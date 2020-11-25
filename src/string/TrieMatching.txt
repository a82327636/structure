package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: TrieMatching
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/29 14:05
 * @Version: 1.0
 */
public class TrieMatching {

    private TrieNode root = new TrieNode("/".charAt(0)); // 存储无意义的字符

    // 往trie树中插入一个字符串
    public void insert(char[]text){
        TrieNode p = root;
        for(int i = 0;i<text.length;++i){
            int index = text[i] - 'a'; // a的ascii码是97
            if(p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // 在trie树中查找一个字符串
    public boolean find(char[]pattern){
        TrieNode p = root;
        for(int i = 0;i<pattern.length;++i){
            int index = pattern[i] - 'a';
            if(p.children[index]==null){
                return false; // 不存在
            }
            p = p.children[index];
        }
        if(p.isEndingChar==false) return false; // 不能完全匹配(如果不需要完全匹配，可以注释掉代码)
        else return true; // 匹配完成
    }
}
