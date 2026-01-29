//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 11259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        int l = 0;
        HashMap<Character, Integer> cnt = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s[i];
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while(cnt.get(c) > 1) {
                cnt.put(s[l], cnt.get(s[l]) - 1);
                l ++;
            }
            ans = Math.max(ans, i-l+1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
