package stack.leetcode;

import java.util.Stack;

/**
 * @ProjectName: structure
 * @Package: stack.leetcode
 * @ClassName: EvalRPN
 * @Author: zwj
 * @Description: 注释 逆波兰式 也叫后缀表达式（将运算符写在操作数之后）
 *
 * 如：我们平时写a+b，这是中缀表达式，写成后缀表达式就是：ab+
 *
 * 实现逆波兰式的算法，难度并不大，但为什么要将看似简单的中序表达式转换为复杂的逆波兰式？
 * 原因就在于这个简单是相对人类的思维结构来说的，对计算机而言中序表达式是非常复杂的结构。
 * 相对的，逆波兰式在计算机看来却是比较简单易懂的结构。
 * 因为计算机普遍采用的内存结构是栈式结构，它执行先进后出的顺序。
 *
 *
 *
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * @Date: 2019/10/18 10:09
 * @Version: 1.0
 */
public class EvalRPN {


    /**
     * 算法思路
     * 1：只使用一个栈，循环数组
     * 2：只需要把数字压栈
     * 3：当遇到符号时，把数字出栈做计算，然后再压栈
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }


    /**
     * 算法思路 ：
     * 1：两个栈，其中一个存储数字，另一个存储符号
     * 2：压入数字进栈，遇到符号时，取数字栈顶，如果算术表达式已经存在，则取一个数字即可，否则需要取两个。
     * 3: 将已经存在的算术表达式使用括号包括起来
     *
     */
}
