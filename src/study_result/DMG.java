package study_result;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: DMG
 * @Author: zwj
 * @Description: 注释 德摩根定律
 * @Date: 2019/11/14 10:34
 * @Version: 1.0
 */
public class DMG {

    // https://blog.csdn.net/m0_37697335/article/details/84979190

    /***
     * 【从右至左可计算性】
     *
     *  如果一个函数能够以位元为单位从右至左计算出来，那么它就肯定能用那5个简单操作及复合指令实现
     *  反之，如果能用这些基本指令来描述一个函数，那么它必然也能通过从右至左的按位运算方式做出来。
     *
     */


    /**
     *  【位操作新式用法】
     *
     *   给定一个数，然后找出下一个比它大而且值为1的位元数与之相同的数字。
     *
     *   有什么用？
     *   用在以位串来表示子集的领域.
     *
     *
     *
     */

    public static void main(String[] args) {
        // 负数的二进制位表示 == 正数的二进制反码 然后再+1（补码）
//        System.out.println(Integer.toBinaryString(-8));
//        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(8&-8));

//        int i = 1;
//        if(i!=1 && i!=2){
//            System.out.println("&&");
//        }
//        if(i!=1 || i!=2){
//            System.out.println("||");
//        }

        System.out.println(Integer.toBinaryString(12));
        execute(12); // 给定一个数，然后找出下一个比它大而且值为1的位元数与之相同的数字

    }



    // 给定一个数，然后找出下一个比它大而且值为1的位元数与之相同的数字
    public static void execute(int x){
        System.out.println("-x= "+Integer.toBinaryString(-x));
        int s = x&-x; // 获取最右侧且值为1的位
        System.out.println("s= "+Integer.toBinaryString(s));
        int y = s+x;
        System.out.println("y= "+Integer.toBinaryString(y)); //
        int r = x^y;
        System.out.println("r(e)= "+r);
        System.out.println("r= "+Integer.toBinaryString(r)); // 把位串中剩下的n-1个1移动到右侧，首先计算x和y的异或值(相等的等于0,不相等的等于1)
        r=(r>>2)/s;
        System.out.println(Integer.toBinaryString(y|r));
    }

    public static void execute1(){
        /**
         * 按位取反 相当求某数的"一补码"(俗称飞“反码” 补码=反码+1)
         * 求相反数 相当于求某数的 "二补码"（俗称"补码"）
         */


    }
}
