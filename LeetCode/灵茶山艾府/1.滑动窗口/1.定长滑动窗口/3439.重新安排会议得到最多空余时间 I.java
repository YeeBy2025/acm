//给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
//
// 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为
// [startTime[i], endTime[i]] 。
//
// 你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时
//间。
//
// 移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
//
// 请你返回重新安排会议以后，可以得到的 最大 空余时间。
//
// 注意，会议 不能 安排到整个活动的时间以外。
//
//
//
// 示例 1：
//
//
// 输入：eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
//
//
// 输出：2
//
// 解释：
//
//
//
// 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。
//
// 示例 2：
//
//
// 输入：eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
//
//
// 输出：6
//
// 解释：
//
//
//
// 将 [2, 4] 的会议安排到 [1, 3] ，得到空余时间 [3, 9] 。
//
// 示例 3：
//
//
// 输入：eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
//
//
// 输出：0
//
// 解释：
//
// 活动中的所有时间都被会议安排满了。
//
//
//
// 提示：
//
//
// 1 <= eventTime <= 10⁹
// n == startTime.length == endTime.length
// 2 <= n <= 10⁵
// 1 <= k <= n
// 0 <= startTime[i] < endTime[i] <= eventTime
// endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。
//
//
// Related Topics 贪心 数组 滑动窗口 👍 82 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class SpareTime {
        public int start;
        public int end;

        public SpareTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // 先假定排好序了
        ArrayList<SpareTime> spareTimes = new ArrayList<>();
        int len = startTime.length;
        if (startTime[0] > 0) spareTimes.add(new SpareTime(0, startTime[0]));
        for(int i = 0; i < len-1; i ++) {
            if (endTime[i] <= startTime[i+1]) {
                spareTimes.add(new SpareTime(endTime[i], startTime[i+1]));
            }
        }
        if (endTime[len-1] < eventTime) spareTimes.add(new SpareTime(endTime[len-1], eventTime));

        len = spareTimes.size();
        if (len == 0) return 0;
        if (len == 1) return spareTimes.get(0).end - spareTimes.get(0).start;
        int ans = 0;
        k = k+1;
        int[] arr = new int[len];
        for(int i = 0; i < len; i ++) {
            arr[i] = spareTimes.get(i).end - spareTimes.get(i).start;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            int l = i-k+1;
            if (l < 0) continue;
            ans = Math.max(ans, sum);
            sum -= arr[l];
        }
        ans = Math.max(ans, sum);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion
