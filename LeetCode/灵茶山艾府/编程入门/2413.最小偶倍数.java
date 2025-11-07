//给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
//
//
//
// 示例 1：
//
// 输入：n = 5
//输出：10
//解释：5 和 2 的最小公倍数是 10 。
//
//
// 示例 2：
//
// 输入：n = 6
//输出：6
//解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 150
//
//
// Related Topics 数学 数论 👍 159 👎 0
/**
 * 最大公约数、最小公倍数模板
 */

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    // Method to calculate GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Method to calculate LCM
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public int smallestEvenMultiple(int n) {
        return lcm(2, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
