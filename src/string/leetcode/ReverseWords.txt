package string.leetcode;

/**
 * @ProjectName: structure
 * @Package: string.leetcode
 * @ClassName: ReverseWords
 * @Author: zwj
 * @Description: 注释 151 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 *
 * @Date: 2019/10/29 14:37
 * @Version: 1.0
 */
public class ReverseWords {

    /**
     * 核心思路
     * 1：首先将字符串打乱成一个由单词和空格和特殊符号组成的数组
     * 2：数组首尾调换，遇到空格是，将调换的单词再做首尾调换
     *
     * 以下的方法需要使用额外的空间 res来存储，并不是最优的选择
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        //用来标记是不是第一个单词，是第一个单词，前面就不加" "；
        boolean first = true;
        //统计这个单词有几个字符
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                cnt++;
                continue;
            }
            if (cnt != 0) {
                if (first) {
                    first = false;
                } else {
                    res.append(" ");
                }
                res.append(s.substring(i + 1, i + 1 + cnt));
                cnt = 0;
            }

        }
        if (cnt != 0) {
            if (!first) {
                res.append(" ");
            }

            res.append(s.substring(0, cnt));
        }

        return res.toString();

    }

}
