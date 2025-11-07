//给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
//
// 返回峰值元素的下标。
//
// 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
//
//
//
// 示例 1：
//
//
//输入：arr = [0,1,0]
//输出：1
//
//
// 示例 2：
//
//
//输入：arr = [0,2,1,0]
//输出：1
//
//
// 示例 3：
//
//
//输入：arr = [0,10,5,2]
//输出：1
//
//
//
//
// 提示：
//
//
// 3 <= arr.length <= 10⁵
// 0 <= arr[i] <= 10⁶
// 题目数据 保证 arr 是一个山脉数组
//
//
// Related Topics 数组 二分查找 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 这种题我是怎么做到一遍过的？不敢相信，我以前对于处理二分边界可头疼了
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0; int r = arr.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;
            if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) l = mid;
            else if (arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]) r = mid;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
