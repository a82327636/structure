package array.leetcode;

import java.util.Arrays;

/**
 * @ProjectName: structure
 * @Package: array.leetcode
 * @ClassName: MajorElement
 * @Author: zwj
 * @Description: 注释
 *
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 [n/2] 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2

 * @Date: 2019/10/17 10:45
 * @Version: 1.0
 */
public class MajorElement {

    public static void main(String[] args) {
        int[]nums = new int[]{143,146,145,149,149};
        System.out.println(majorityElement(nums));
        System.out.println("********************");
        System.out.println(majorityElement1(nums));
    }


    /**
     *  143,146,145,149,149 得到146，错误
     * 如果所有数字被单调递增或者单调递减的顺序排了序，那么众数的下标为 [n/2]
     * （当 nn 是偶数时，下标为 [n/2+1]）
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    /**
     * 摩尔投票法
     * 再来回顾一下题目：寻找数组中超过一半的数字，这意味着数组中其他数字出现次数的总和都是比不上这个数字出现的次数 。
     *
     * 即如果把 该众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，和是大于 0 的。
     *
     * 所以可以这样操作：
     *
     * 设置两个变量 candidate 和 count，candidate 用来保存数组中遍历到的某个数字，count 表示当前数字的出现次数
     * ，一开始 candidate 保存为数组中的第一个数字，count 为 1
     * 遍历整个数组
     * 如果数字与之前 candidate 保存的数字相同，则 count 加 1
     * 如果数字与之前 candidate 保存的数字不同，则 count 减 1
     * 如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
     * 遍历完数组中的所有数字即可得到结果
     *
     */

    public static int majorityElement1(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else{
                count--;
            }
        }
        return candidate;
    }


}
