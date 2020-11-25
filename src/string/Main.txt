package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/24 15:36
 * @Version: 1.0
 */
public class Main {

    // 1: 实现一个字符集，只包含a~z这26个英文字母的Trie树
    // 2: 实现朴素的字符串匹配算法


    public static void main(String[] args) {

//        // 2.1 实现朴素的字符串匹配算法(bf)
//        BFmatching bFmatching = new BFmatching();
//        //System.out.println(bFmatching.bF("aaaaaaa","aab"));
//        System.out.println(bFmatching.bF("aabaaaa","aaa"));
//
//        // 2.2 实现朴素的字符串匹配算法(rk)
//        RKmatching rKmatching = new RKmatching();
//        System.out.println(rKmatching.rK("aabaaaa","aaa"));

        // 1: 实现一个字符集，只包含a~z这26个英文字母的Trie树
        TrieMatching trieMatching = new TrieMatching();
        trieMatching.insert(new char[]{'h','e','l','l','o'});
        trieMatching.insert(new char[]{'h','i'});
        trieMatching.insert(new char[]{'y','e','s'});
        trieMatching.insert(new char[]{'n','o'});
        System.out.println(trieMatching.find(new char[]{'h','e','l','l','o'}));
        System.out.println(trieMatching.find(new char[]{'h','e'}));
        System.out.println(trieMatching.find(new char[]{'h','b'}));
    }

}
