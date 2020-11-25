package study_result;

import java.util.HashMap;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Formula
 * @Author: zwj
 * @Description: 注释 公式
 * @Date: 2019/11/15 10:21
 * @Version: 1.0
 */
public class Formula {


    public static void main(String[] args) {
        int a = 3;
        int b = 8;
//        System.out.println((a|b)-((a^b)>>1));// 获取两个数的平均值(无符号数) >>1 = /2
//        System.out.println(b+((a-b)>>1)); // 获取两个数的平均值(a>=b)

        /**
         * 符号扩展
         *
         *
         */

        // 0x00000080 是0x16进制
        // 以0x开始的数据表示16进制，计算机中每位的权为16，即（16进制)10 = (10进制)1×16
//        System.out.println(Integer.parseInt("00000080",16)); // 得到十进制128
//        System.out.println(Integer.parseInt("000000FF",16)); // 得到十进制255
//        System.out.println(Integer.parseInt("0000007F",16)); // 得到十进制127
         // System.out.println(Long.parseLong("FFFFFFFF",16)); // 得到十进制127 4294967295(32位长)
//        System.out.println(Long.parseLong("80000000",16)>>31); // 得到十进制2147483648(32位长)
//        System.out.println(Integer.toBinaryString(128)); // 得到二进制10000000
//        System.out.println(Integer.toBinaryString(127)); // 得到二进制01111111
//        System.out.println(Integer.toBinaryString(255)); // 得到二进制11111111
         // System.out.println(Long.toBinaryString(4294967295l));// 得到二进制11111111111111111111111111111111(32位长)
//        System.out.println(Long.toBinaryString(2147483648l)); // 得到二进制10000000000000000000000000000000(32位长)
//
//        int x = -5;
//        System.out.println(-(x>>31)|(-x>>31));// 判断x>0 or x=0 or x<0
//        System.out.println((a^b)>>31); // 符号传递 获取符号位符号
          verify();
    }


    private static void verify(){
        /**
         * 溢出检测
         */

        /**
         * 二进制中的0表示为2^n次方.
         * 10 = 2^1
         * 100 = 2^2
         * 1000 = 2^3
         */

        int a1 = 4,a2 = 5,a3 = 6;

//        System.out.println((a1&a2)|((a1|a2)&~(a1+a2+a3)));

//        System.out.println((a1<<29) | (a1>>(32-29)));
//        System.out.println((a1<<29));
//
//        System.out.println((a1>>(32-29)));
//
//        System.out.println(Long.parseLong("FFFFFF00",16));

//        System.out.println(a2-a1<=a3-a1); // 替换掉 a1<=a2<=a3的写法



//        System.out.println(Long.parseLong("AAAAAAAA",16));
//        System.out.println(Integer.parseInt("55555555",16));
//        System.out.println(Integer.parseInt("0000003F",16));
//        System.out.println(Integer.parseInt("33333333",16));
//        System.out.println(Integer.parseInt("0F0F0F0F",16));
//        System.out.println(Integer.parseInt("00FF00FF",16));
//        System.out.println(Integer.parseInt("7FFFFFFF",16));
//        System.out.println(Long.toBinaryString(Long.parseLong("AAAAAAAA",16)));
//        System.out.println("55555555: "+Integer.toBinaryString(Integer.parseInt("55555555",16)));
//        System.out.println("0000003F: "+Integer.toBinaryString(Integer.parseInt("0000003F",16)));
//        System.out.println("33333333: "+Integer.toBinaryString(Integer.parseInt("33333333",16)));
//        System.out.println("0F0F0F0F: "+Integer.toBinaryString(Integer.parseInt("0F0F0F0F",16)));
//        System.out.println("00FF00FF: "+Integer.toBinaryString(Integer.parseInt("00FF00FF",16)));
//        System.out.println("7FFFFFFF: "+Integer.toBinaryString(Integer.parseInt("7FFFFFFF",16)));
//        System.out.println("***********************");
//        System.out.println(Long.toBinaryString(Long.parseLong("77777777",16)));
//        System.out.println(Integer.toBinaryString(Integer.parseInt("01010101",16)));
//        System.out.println(Integer.toBinaryString(Integer.parseInt("11111111",16)));
//        System.out.println("***********************");
//
        int x = 12345;
//        System.out.println(Integer.toBinaryString(x));
//        x = (x & Integer.parseInt("55555555",16)) + ((x>>1)& Integer.parseInt("55555555",16));
//        System.out.println(Integer.toBinaryString(x));
//        x = (x & Integer.parseInt("33333333",16)) + ((x>>2)& Integer.parseInt("33333333",16));
//        System.out.println(Integer.toBinaryString(x));
//        x = (x & Integer.parseInt("0F0F0F0F",16)) + ((x>>4)& Integer.parseInt("0F0F0F0F",16));
//        System.out.println(Integer.toBinaryString(x));
//        x = (x & Integer.parseInt("00FF00FF",16)) + ((x>>8)& Integer.parseInt("00FF00FF",16));
//        System.out.println(Integer.toBinaryString(x));
//        x = (x & Integer.parseInt("0000FFFF",16)) + ((x>>16)& Integer.parseInt("0000FFFF",16));
//        System.out.println(Integer.toBinaryString(x));
//
//
        System.out.println("############################");
        //System.out.println(pop(12345));
        System.out.println(pop1(12345));

        System.out.println("############################");
//
//        int h = 0;
//        String k = "123";
//        System.out.println(Integer.toBinaryString(k.hashCode()));
//        h ^= k.hashCode();
//        System.out.println(Integer.toBinaryString(h));
//        System.out.println(Integer.toBinaryString(h >>> 20));
//        System.out.println(Integer.toBinaryString(h >>> 12));
//        System.out.println(Integer.toBinaryString((h >>> 20) ^ (h >>> 12)));
//        h ^= (h >>> 20) ^ (h >>> 12);
//        System.out.println(Integer.toBinaryString(h));
//        System.out.println(h ^ (h >>> 7) ^ (h >>> 4));
//        System.out.println(h);
    }



    private static int pop(int x){
        x = x-((x>>1)&Integer.parseInt("55555555",16));
        x = (x&Integer.parseInt("33333333",16) + ((x>>2)&Integer.parseInt("33333333",16)));
        x = (x+(x>>4)&Integer.parseInt("0F0F0F0F",16));
        x = x+(x>>8);
        x = x+(x>>16);
        return x&Integer.parseInt("0000003F",16);
    }

    private static int pop1(int x){
        int n = 0;
        while(x!=0){
            n=n+1;
            x = x&(x-1);
        }
        return n;
    }
}
