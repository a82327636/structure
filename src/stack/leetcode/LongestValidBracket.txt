package stack.leetcode;

import java.util.Stack;

/**
 * @ProjectName: structure
 * @Package: stack.leetcode
 * @ClassName: LongestValidBracket
 * @Author: zwj
 * @Description: 注释 最长有效括号(连续最长有效括号，如果中间有不标准括号，则重新做统计，然后与之前的做比较)
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @Date: 2019/10/17 17:04
 * @Version: 1.0
 */
public class LongestValidBracket {


    /**
     * 暴力算法 （只针对字符串只有括号的情况）
     *
     * 在这种方法中，我们考虑给定字符串中每种可能的非空偶数长度子字符串，
     * 检查它是否是一个有效括号字符串序列。为了检查有效性，我们使用栈的方法。
     *
     * 每当我们遇到一个 ‘(’ ，我们把它放在栈顶。对于遇到的每个 ‘)’
     * ，我们从栈中弹出一个 ‘(’ ，如果栈顶没有 ‘(’，
     * 或者遍历完整个子字符串后栈中仍然有元素，那么该子字符串是无效的。这种方法中，
     * 我们对每个偶数长度的子字符串都进行判断，并保存目前为止找到的最长的有效子字符串的长度。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }


    /**
     * 方法 2：动态规划
     *
     */


    /**
     * 方法 3：栈
     * 算法
     *
     * 与找到每个可能的子字符串后再判断它的有效性不同，我们可以用栈在遍历给定字符串的过程中去判断到目前
     * 为止扫描的子字符串的有效性，同时能的都最长有效字符串的长度。我们首先将 -1 放入栈顶。
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
     * 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，
     * 得出当前有效括号字符串的长度。通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
     *
     */
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    /***
     * 自己的算法思路：
     * 1：需要一个变量success来记录匹配好的次数。
     * 2：使用两个栈，一个压开括号“（”，一个压闭括号“）”。
     * 3：当压闭括号时，判断开括号的栈是否存在element，如果存在则取出栈顶 success++。
     */
}
