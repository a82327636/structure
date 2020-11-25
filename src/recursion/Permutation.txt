package recursion;

/**
 * @ProjectName: structure
 * @Package: recursion
 * @ClassName: Permutation
 * @Author: zwj
 * @Description: 注释 全排列 定位与转换
 *
 * 公式：
 * 1：循环数组
 * 2：从数组中依次找一个下标值为首，然后循环剩余数值做交换
 * 3：当数字长度等于最后一个交换次数时，输出值
 * 4：将交换后的顺序还原为交换前顺序
 *
 *
 * 如:
 * 数组[1,2,3]
 * 1：   从数组第一个元素“1”开始，那么此时就是对“23”进行全排列，递归的下标再加一，这三下标指向元素变为“2”，
 * 此时对“3”进行全排列，元素“3”全排列结果就是自己继续递归，下标值等于数组长度，递归结束，输出“123”；
 * 2：   上一步递归结束后，此时下标指向元素“2”，此时对元素“23”全排列，将“2”与“3”交换，继续递归，下标值等于数组长度，递归结束，输出“132”；
 * 3：   再回归到下标为1，这时开始以第二个元素"2"为开始，先将2与1交换  swap(tar,begin,i); 这里的begin不变在，首循环中一直为0.然后再开始对"1,3"全排列
 * @Date: 2019/10/21 10:46
 * @Version: 1.0
 */
public class Permutation {


    public static void sort_it(int[] tar,int begin) {
        if(begin==tar.length) {
            StringBuffer sbf = new StringBuffer();
            for(int tar1:tar){
                sbf.append(tar1).append("  ");
            }
            System.out.println(sbf.toString());
        }

        for(int i=begin;i<tar.length;i++) {
//            if(is_too(tar,begin,i)) {//判断重复元素
                swap(tar,begin,i);
                sort_it(tar, begin+1);
                swap(tar, i, begin);
//            }
        }
    }

    private static void swap(int[]tar, int left, int right) {
        int temp = tar[left];
        tar[left] = tar[right];
        tar[right] = temp;
    }

    public static boolean is_too(int[] tar,int begin,int end) {
        boolean flag=true;

        for(int i=begin;i<end;i++) {
            if(tar[i]==tar[end]) return false;
        }

        return flag;
    }

}
