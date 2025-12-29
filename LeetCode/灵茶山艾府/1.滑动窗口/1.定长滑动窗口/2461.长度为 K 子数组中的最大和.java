//给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
//
//
// 子数组的长度是 k，且
// 子数组中的所有元素 各不相同 。
//
//
// 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
//
// 子数组 是数组中一段连续非空的元素序列。
//
//
//
// 示例 1：
//
// 输入：nums = [1,5,4,2,9,9,9], k = 3
//输出：15
//解释：nums 中长度为 3 的子数组是：
//- [1,5,4] 满足全部条件，和为 10 。
//- [5,4,2] 满足全部条件，和为 11 。
//- [4,2,9] 满足全部条件，和为 15 。
//- [2,9,9] 不满足全部条件，因为元素 9 出现重复。
//- [9,9,9] 不满足全部条件，因为元素 9 出现重复。
//因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
//
//
// 示例 2：
//
// 输入：nums = [4,4,4], k = 3
//输出：0
//解释：nums 中长度为 3 的子数组是：
//- [4,4,4] 不满足全部条件，因为元素 4 出现重复。
//因为不存在满足全部条件的子数组，所以返回 0 。
//
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
// Related Topics 数组 哈希表 滑动窗口 👍 101 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            int l = i-k+1;
            if (l < 0) continue;
            if (mp.size() == k) ans = Math.max(s, ans);
            int out = nums[l];
            s -= out;
            int c = mp.get(nums[l]);
            if (c > 1) mp.put(nums[l], c-1);
            else mp.remove(out);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
