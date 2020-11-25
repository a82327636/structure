package thought.dynamic_plan;

import java.util.Arrays;

/**
 * @ProjectName: structure
 * @Package: thought.dynamic_plan
 * @ClassName: LengthOfLIS
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/7 11:13
 * @Version: 1.0
 */
public class LengthOfLIS {

    /**
     * 算法思路
     * 动态规划
     *
     * 新增一个dp数组,dp[i]对应的是nums[]最长递增序列值
     * nums[j] = nums[i-1]
     * if nums[j] < nums[i] then dp[i]+1
     *
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    /**
     * 动态规划 + 二分查找
     * 增加二分查找 最多值需要使用tails的一半空间以及时间
     */
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }


}
