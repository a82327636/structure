package thought.leetcode;

/**
 * @ProjectName: structure
 * @Package: thought.leetcode
 * @ClassName: MaxProduct
 * @Author: zwj
 * @Description: 注释 乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * @Date: 2019/11/8 10:07
 * @Version: 1.0
 */
public class MaxProduct {

    /**
     * 算法思路
     * 1：负数*负数=正数
     * 2：正数*负数=负数
     * 如：[2,3,-2,4]
     * 2*3 = 6 // 所以这个最大
     * 6*-2=-12
     * -12*4=-48
     */

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ //如果存在负数，则交换imax 与 imin  因为一旦遇到负数，最大值就变成最小值，而最小值变成最大值
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


}
