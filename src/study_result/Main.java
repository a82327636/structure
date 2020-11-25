package study_result;

import java.util.HashMap;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/13 15:56
 * @Version: 1.0
 */
public class Main {


    /***
     * 与运算 （“  & ”）
     * 参与运算的两个数据，按照二进制位进行“与运算”。
     * 运算规则：0&0=0;   0&1=0;   1&0=0;    1&1=1;
     * 即：两位同时为1，则值为1。否则为0
     * 例如：6 & 7 = 110 & 111 = 110 = 6
     * 8 & 3 = 1000 & 11 = 0 = 0
     *
     * 特殊用法
     *
     * （1）清零。如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都是零的数值相与，结果为零。
     *
     * （2）取一个数中指定位。
     *
     * 例如：设X=10101110，取X的低四位，用X&0000 1111=0000 1110即可得到。
     *
     * 方法：找一个数，对应x要取的位，该数的对应位为1，其余位为零，此数与x进行“与运算”可以得到x中的指定位

     *
     *
     * 或运算 （“ | ”）　
     * 参与运算的两个数据，按照二进制位进行“或运算”。
     * 运算规则：0|0=0;   0|1=1;   1|0=1;    1|1=1;
     * 即：参与运算的两个数据只要有一个值为1 那么值为1
     * 例如：12 | 5 = 1100 | 101 = 1101 = 13
     * 4 | 5 = 100 | 101 = 101 = 5
     *
     * 特殊用法 (交换位置)
     *
     * 常用来对一个数据的某些位置1。
     * 方法：找到一个数，对应x要置1的位，该数的对应位为1，其余位为零。此数与x相或可使x中的某些位置1。
     *
     *
     * 异或运算 （“ ^ ”）
     * 参与 运算的两个数据，按照二进制位进行“异或运算”。
     * 运算规则： 0^0=0;   0^1=1;   1^0=1;    1^1=0;
     * 即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
     * 例如：9^5可写成算式如下： 00001001^00000101=00001100 (十进制为12)可见9^5=12
     *
     * 特殊用法
     *
     * （1） 与1相异或，使特定位翻转
     * 方法：找一个数，对应X要翻转的位，该数的对应为1，其余位为零，此数与X对应位异或即可。
     * 例如：X=1010 1110，使X低四位翻转，用X^0000 1111=1010 0001即可得到。
     *
     * （2） 与0相异或，保留原值
     * 例如：X^0000 0000 =1010 1110
     *
     * （3）两个变量交换值
     *
     * 1.借助第三个变量来实现
     * C=A;A=B;B=C;
     *
     * 2.利用加减法实现两个变量的交换
     * A=A+B;B=A-B;A=A-B;
     *
     * 3.用位异或运算来实现，也是效率最高的
     *
     * 原理：一个数异或本身等于0 ；异或运算符合交换律
     * A=A^B;B=A^B;A=A^B
     *
     *
     * （四）取反与运算~
     * 对一个二进制数按位取反，即将0变为1，1变0
     * ~1=0 ；~0=1
     *
     * （五）左移<<
     *
     * 将一个运算对象的各二进制位全部左移若干位（左边的二进制位丢弃，右边补0）
     *
     * 例如： 2<<1 =4 10<<1=100
     *
     * 若左移时舍弃的高位不包含1，则每左移一位，相当于该数乘以2。
     *
     * 例如：
     *
     * 11(1011)<<2= 0010 1100=22
     *
     * 11(00000000 00000000 00000000 1011)整形32bit
     *
     * （六）右移>>
     *
     * 将一个数的各二进制位全部右移若干位，正数左补0，负数左补1，右边丢弃。
     * 若右移时舍高位不是1（即不是负数），操作数每右移一位，相当于该数除以2。
     *
     * 左补0还是补1得看被移数是正还是负。
     *
     * 例如：4>>2=4/2/2=1
     *
     * -14（即1111 0010）>>2 =1111 1100=-4
     *
     * （七）无符号右移运算>>>
     *
     * 各个位向右移指定的位数，右移后左边空出的位用零来填充，移除右边的位被丢弃。
     *
     * 例如：-14>>>2
     *
     * （即11111111 11111111 11111111 11110010）>>>2
     *
     *  =(00111111 11111111 11111111 11111100)=1073741820
     *
     *  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *
     *  上述提到的负数，他的二进制位表示和正数略有不同，所以在位运算的时候也与正数不同。
     *
     *  负数以其正数的补码形式表示！
     *
     * 以上述的-14为例，来简单阐述一下原码、反码和补码。
     *
     * 原 码
     *
     * 一个整数按照绝对值大小转化成的二进制数称为原码
     *
     * 例如：00000000 00000000 00000000 00001110 是14的原码。
     *
     * 反 码
     *
     * 将二进制数按位取反，所得到的新二进制数称为原二进制数的反码。
     *
     * 例如：将00000000 00000000 00000000 00001110 每一位取反，
     *
     * 得11111111 11111111 11111111 11110001
     *
     * 注意：这两者互为反码
     *
     * 补 码
     *
     * 反码加1称为补码
     *
     * 11111111 11111111 11111111 11110001 +1=
     *
     * 11111111 11111111 11111111 11110010
     *
     * 现在我们得到-14的二进制表示，现在将它左移
     *
     * -14（11111111 11111111 11111111 11110010）<<2 =
     *
     * 11111111 11111111 11111111 11001000
     *
     * =？
     *
     * 分析：这个二进制的首位为1，说明是补码形式，现在我们要将补码转换为原码（它的正值）
     *
     * 跟原码转换为补码相反，将补码转换为原码的步骤：
     *
     * 补码减1得到反码：（11000111）前24位为1，此处省略
     * 反码取反得到原码（即该负数的正值）（00111000）
     * 计算正值，正值为56
     * 取正值的相反数，得到结果-56
     * 结论：-14<<2 = -56
     *
     * 总结：正数的左移与右移，负数的无符号右移，就是相应的补码移位所得，在高位补0即可。
     * 负数的带符号右移，就是补码高位补1,然后按位取反加1即可。(与上面的补码-1得到反码，反码取反得到原码一样 )
     *
     * (带符号右移后) -> 11001000 -> 00110111+1 = 00111000
     */

    public static void main(String[] args) {
        execute();
    }

    private static void execute(){
        String i1 = Integer.toBinaryString(-5);
        System.out.println(i1);
         System.out.println(Integer.valueOf("10100",2).toString());
//
//        System.out.println(Integer.toBinaryString(8&-8)); // n&(-n)==n 表示n是2的幂次方
//        System.out.println(Integer.toBinaryString(8&7)); // n&(n-1)==0 表示n是2的幂次方
//        System.out.println("********************");
//        System.out.println(Integer.valueOf("10100111",2).toString());
//        System.out.println(Integer.valueOf("10101111",2).toString());
//        System.out.println(Integer.toBinaryString(167|175));

        System.out.println("********************");

//        System.out.println( 1 << 4);
//        System.out.println( 1 << 30);

        /**
         * * （3）两个变量交换值
         *      *
         *      * 1.借助第三个变量来实现
         *      * C=A;A=B;B=C;
         *      *
         *      * 2.利用加减法实现两个变量的交换
         *      * A=A+B;B=A-B;A=A-B;
         *      *
         *      * 3.用位异或运算来实现，也是效率最高的
         *      *
         *      * 原理：一个数异或本身等于0 ；异或运算符合交换律
         *      * A=A^B;B=A^B;A=A^B
         */

        int A = 4;
        int B = 5;
//        A = A+B;
//        System.out.println(A);
//        B = A-B;
//        System.out.println(B);
//        A = A-B;
//        System.out.println(A);
          System.out.println(Integer.toBinaryString(A));
          System.out.println(Integer.toBinaryString(B));
          System.out.println("***********");
          A = A^B;
          System.out.println(Integer.toBinaryString(A));
          System.out.println(Integer.toBinaryString(B));
          System.out.println(A);
          System.out.println("***********");
          B = A^B;
          System.out.println(Integer.toBinaryString(A));
          System.out.println(Integer.toBinaryString(B));
          System.out.println(B);
          System.out.println("***********");
          A = A^B;
          System.out.println(Integer.toBinaryString(A));
          System.out.println(Integer.toBinaryString(B));
          System.out.println(A);
          System.out.println("***********");

    }
}

