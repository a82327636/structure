package thought.leetcode;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: IsMatch
 * @Author: zwj
 * @Description: 注释 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 *
 * @Date: 2019/11/8 10:31
 * @Version: 1.0
 */
public class IsMatch {

    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;

    // 自顶向下方法
    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){ // 如果pattern 到了结尾(针对.*这样的pattern，就会一直延续到i=text.length)
            ans = i == text.length(); // 判断是否也到了text的结尾
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){// pattern 存在下一个字符，且字符为*
                // 只要满足某一种就可以
                // 1: dp(i,j+2,text,pattern) --> 表示*号的意思是取除pattern[j]这个字符，直接和pattern[j+2]比较
                // 2: first_match && dp(i+1,j,text,pattern) -- > 第一个字符已经匹配成功，开始匹配第二个text[i+1],因为j+1是*这里表示多个pattern[j],所以继续匹配pattern[j]
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));

            } else {
                ans = first_match && dp(i+1, j+1, text, pattern); // 第一个字符已经匹配成功，然后开始匹配第二个字符
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }


    // 自底向上方法(做了多余的事不好)
    public boolean isMatch1(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true; // 末尾默认为true

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
