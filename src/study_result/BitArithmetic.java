package study_result;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Binary_Arithmetic
 * @Author: zwj
 * @Description: 注释 位运算实现四则运算
 * @Date: 2019/11/14 15:00
 * @Version: 1.0
 */
public class BitArithmetic {

    /**
     * 计算机系统中，数值一律用补码来表示：因为补码可以使符号位和数值位统一处理，同时可以使减法按照加法来处理。
     * <p>
     * 对补码做简单介绍：数值编码分为原码，反码，补码，符号位均为0正1负。
     * <p>
     * 原码 -> 补码： 数值位取反加1
     * <p>
     * 补码 -> 原码： 对该补码的数值位继续 取反加1
     * <p>
     * 补码 的绝对值（称为真值）：正数的真值就是本身，负数的真值是各位（包括符号位）取反加1（即变成原码并把符号位取反）.
     * <p>
     * b -> -b ： 各位（包括符号位）取反加1
     * <p>
     * <p>
     * 首先回忆计算机组成原理学过的内容，数字在机器ALU运算逻辑单元内部是以补码形式进行运算的，因为补码有两个优势：
     * <p>
     * 1、能做到符号位和数值部分一起运算，这样无需单独考虑符号。
     * <p>
     * 2、能把减法运算转化为加法运算来处理。
     * <p>
     * 3、补码的没有正0和负0之分，所以表示范围比原码和反码多1个。
     */

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));

        System.out.println(2&1);

        //System.out.println(add(4, 5)); // 加法一

        //System.out.println(subtraction(4,5));// 减法

//        System.out.println(multiply(4,5)); // 乘法一
//        System.out.println(multiply2(4,5)); // 乘法二

        System.out.println(divide2(20,4)); // 除法二

    }


    /**
     * 位运算实现加法
     * <p>
     * 不管是十进制加法还是二进制加法，其加的的过程在每一位来看 都分为‘和’、‘进位’两个部分。
     * ‘和’要留在当前位，‘进位’加入到下一位。
     * <p>
     * 我们现在关注二进制加法。发现一个特点。
     * <p>
     * 位的异或运算跟求'和'的结果一致：
     * <p>
     * 异或 1^1=0 1^0=1 0^0=0
     * 求和 1+1=0 1+0=1 0+0=0
     * <p>
     * <p>
     * 位的与运算跟求'进位‘的结果一致：
     * <p>
     * 位与 1&1=1 1&0=0 0&0=0
     * 进位 1+1=1 1+0=0 0+0=0
     */

    private static int add(int a, int b) //递归形式
    {
        if (b == 0) //递归结束条件：如果右加数为0，即不再有进位了，则结束。
            return a;
        int s = a ^ b; // 个位求和
        int c = (a & b) << 1; //进位左移1位，达到进位的目的。
        return add(s, c); //再把'和'和'进位'相加。递归实现。
    }


    private static int add1(int a, int b) //非递归形式
    {
        int s, c;
        while (b != 0) {
            s = a ^ b; // 个位求和
            c = (a & b) << 1; //进位左移1位，达到进位的目的。
            a = s; // a = 和
            b = c; // b = 进位
        }
        return a;
    }


    /**
     * 位运算实现减法
     *
     * 减法其实是用加法来实现的。
     *
     * 在ALU（运算器）中，当我求a-b，其实是求[a-b]
     *
     * 因为有[a-b]=[a] - [b]= [a]+[-b]。
     *
     * 所以我就要先求出-b。求一个数的负的操作是将其连符号位一起取反然后加1。
     *
     * 于是有办法做减法了：先把减数求负，然后做加法
     */

    private static int subtraction(int a, int b) //减法运算：利用求负操作和加法操作
    {
        return add(a, negtive(b));
    }

    private static int negtive(int i) // 获取补码
    {
        return add(~i, 1); // 反码+1
    }


    /**
     * 位运算实现乘法
     *
     * 乘法操作时即使用补码也要需要考虑符号位，
     *
     * 所以我要先把符号拿出来单独计算。为了方便，先引入两个工具函数，
     */

    private static int getsign(int i) //取一个数的符号，看是正还是负
    {
        return (i>>31); // 获取最左位是0还是1
    }

    // 将一个数变为正数，如果本来就是正，则不变；如果是负，则变为相反数。注意对于-2147483648，求负会溢出。
    private static int bepositive(int i)
    {
        if (i >> 31 > 0) // 符号位1表示负数，需要先变成补码
            return negtive(i);
        else
            return i;
    }

    /**
     * 做乘法的第一种思路：
     *
     * 很直观，就是用循环加法替代乘法。a*b，就是把a累加b次。时间复杂度为O(N)。
     */
    private static int multiply(int a, int b)
    {
        Boolean flag = true;
        if(getsign(a) == getsign(b)) // 积的符号判定,同为正或同为负时，符号都是为正(负负得正)
            flag = false;

        a = bepositive(a);//先把乘数和被乘数变为正数
        b = bepositive(b);
        int ans = 0;
        while(b>0) // 循环加b次
        {
            ans = add(ans, a);
            b = subtraction(b, 1); // 减法运算,b=b-1次
        }

        if(flag) // 负数的二进制表示形式是补码
            ans = negtive(ans); // 取补码
        return ans;
    }


    /**
     * 做乘法的第二种思路：
     *
     *            0 1 0 0  == 4
     *         *
     *            0 1 0 1  == 5
     *           ---------
     *            0 1 0 0
     *          0 0 0 0
     *        0 1 0 0
     *      0 0 0 0
     *     ----------------
     *      0 0 1 0 1 0 0  == 20
     *
     * 在二进制数上做乘法
     *
     * 这一过程就是根据乘数的每一位为0或1时，将被乘数错位的加在积上。时间复杂度为O(logN)
     */

    private static int multiply2(int a, int b) {
        boolean flag = true;
        if (getsign(a) == getsign(b)) //积的符号判定
            flag = false;

        a = bepositive(a);
        b = bepositive(b);
        int ans = 0;
        while (b>0) {
            if ((b&1)>0){ // 判断b的最右位是否是1，如果是1可以再加一次a
                ans = add(ans, a);
            }
            a = (a << 1); //把a错位加在积上
            b = (b >> 1); //从最低位开始依次判断b的每一位
        }

        if (flag)
            ans = negtive(ans);
        return ans;

    }


    /**
     * 位运算实现除法
     *
     * 做除法的第一种思路：
     *
     * 也比较直观，从被除数上减去除数，看能减多少次之后变得不够减。时间复杂度为O(N)
     *
     *
     */
    private static int division(int a, int b) {
        if (b == 0)
            return 0;

        boolean flag = true;
        if (getsign(a) == getsign(b)) //积的符号判定
            flag = false;

        a = bepositive(a);
        b = bepositive(b);

        int n = 0;
        a = subtraction(a, b); // a-b 的值,可以除几次
        while (a >= 0) {
            n = add(n, 1); // 被减的次数,也就是除了几次
            a = subtraction(a, b);
        }
        if (flag)
            n = negtive(n);
        return n;
    }

    /**
     * 做除法的第二种思路：
     * 第一种方法实在太慢了。
     * 减法得减的快一些，不能一个一个减，于是采用类似二分法的思路，从除数*最大倍数 开始测试，如果比被除数小，则要减去。
     *
     * 下一回让除数的倍数减少为上一次倍数的一半，这样的直到倍数为1时，就能把被除数中所有的除数减去，并得到商。
     *
     * 时间复杂度降低到O(logN)。
     *
     * divide2(20,4) 跑一下代码，加断点看一下，就明白了.
     *
     * (x >> i) >= y // 只有的2的幂次方会进入
     *
     *  i = subtraction(i, 1); // 然后再单独+1次
     */

    private static int divide2(int dividend, int divisor) {
        boolean flag = true;
        if (getsign(dividend) == getsign(divisor)) //积的符号判定
            flag = false;
        int x = bepositive(dividend);
        int y = bepositive(divisor);
        int ans = 0;
        int i = 31; // 最大倍数
        while (i >= 0) {
            //比较x是否大于y*(1<<i)=(y<<i)，避免直接比较，因为不确定y*(1<<i)是否溢出
            if ( (x >> i) >= y)  //如果够减 (如：x=20,y=4 20>>i >= y -- 20除以2的i次方 >= y )
            {
                ans = add(ans, (1 << i)); // 1右移i次,相当于乘以2^i次方
                x = subtraction(x, (y << i));// y右移i次，相当于乘以2^i次方(x-y*2^i)
            }
            i = subtraction(i, 1); // i-1次数
        }
        if (flag)
            ans = negtive(ans);
        return ans;
    }

    /**
     * 注意细节：
     *
     * 1、注意考虑除法运算的特殊情况：除数不为0。
     *
     * 2、int整型的表示范围是-2147483648~+2147483647。
     * 所以在求负的时候，有一个数-2147483648是不可以求负的，因为int无法表示+2147483648这个数。
     * 对于乘法运算，如果出现了这个数，运算就会溢出。
     * 对于除法操作，如果被除数是-2147483648，那么不能直接求负。所以最好采用无符号数来进行运算。
     *
     * 3、2^31，2^30,......,64,32,16,8,4,2,1。
     * 为什么尝试用这样的倍数做减法就能把所有除数都减去呢？
     * 从二进制数的角度来看，这些权值就可以构成所有的整数，组成倍数不会有遗漏。
     * 从折半的思想来看，这样是一个逐步折半细化的过程。
     */

}