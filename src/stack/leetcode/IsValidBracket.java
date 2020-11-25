package stack.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ProjectName: structure
 * @Package: stack.leetcode
 * @ClassName: IsValidBracket
 * @Author: zwj
 * @Description: 注释 有效括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true

 * @Date: 2019/10/17 16:45
 * @Version: 1.0
 */
public class IsValidBracket {

    /**
     * 算法  (只能是字符串只包含这三种符号的情况)
     * 初始化栈 S。
     * 一次处理表达式的每个括号。
     * 如果遇到开括号"("，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
     * 如果我们遇到一个闭括号")"，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
     * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
     *
     * 链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
     */

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash graph with mappings. This simply makes the code easier to read.
    public IsValidBracket() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    /**
     * 上面的算法只能判断字符串中只有这三个括号的情况，如果有其他字符串则行不通，需要下面的算法
     * 还有一种可以使用两个栈来处理，一个栈push符号，另一个push其余字符串,如：先push"("括号，当在此碰到")"括号时，看看括号栈的栈顶是不是"(",这样判断字符串是否有效
     */

}
