package queue.leetcode;

import java.util.ArrayDeque;

/**
 * @ProjectName: structure
 * @Package: queue.leetcode
 * @ClassName: MaxSlidingWindow
 * @Author: zwj
 * @Description: 注释 滑动最大窗口值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 *  [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？

 * @Date: 2019/10/18 15:15
 * @Version: 1.0
 */
public class MaxSlidingWindow {

    /**
     *  暴力算法（不是线性时间，有可能需要n3次方）
     *  使用两个循环i,j，循环数组，第一层i一次移动一步，第二层j一次移动i+2步
     *  然后再第二层循环中在做数据比较
     */


    /**
     * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
     * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
     * 算法
     *
     * 算法非常直截了当：
     * 处理前 k 个元素，初始化双向队列。
     *
     * 遍历整个数组。在每一步 :
     * 清理双向队列 :
     *
     *   - 只保留当前滑动窗口中有的元素的索引。
     *   - 移除比当前元素小的所有元素，它们不可能是最大的。
     *
     * 将当前元素添加到双向队列中。
     * 将 deque[0] 添加到输出中。
     * 返回输出数组
     */


    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];
        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            System.out.println(i - k + 1);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if(!deq.isEmpty() && deq.getFirst() != null){
            System.out.println("first:"+deq.getFirst());
        }
        if(!deq.isEmpty() && deq.getLast() != null){
            System.out.println("last:"+deq.getLast());
        }
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();
        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])  {
            deq.removeLast();
        }
    }


}
