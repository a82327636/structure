package string.leetcode;

/**
 * @ProjectName: structure
 * @Package: string.leetcode
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/29 11:19
 * @Version: 1.0
 */
public class Main {

    // 1: 344 反转字符串
    // 2: 151 翻转字符串里的单词
    // 3: 8 字符串转换整数(atoi)

    public static void main(String[] args) {

        // 1: 344 反转字符串
//        ReverseString reverseString = new ReverseString();
//        char[] ch = new char[]{'h','e','l','l','o'};
//        reverseString.reverseString(ch);
//        for(char ch1:ch){
//            System.out.println(ch1);
//        }
//        System.out.println();

        // 2: 151 翻转字符串里的单词
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the sky is blue"));

        // 3: 8 字符串转换整数(atoi)
//        MyAtoi myAtoi = new MyAtoi();
//        System.out.println(myAtoi.myAtoi("419a3 with words"));
    }
}
