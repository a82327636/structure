package study_result;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Reverse
 * @Author: zwj
 * @Description: 注释 反转字节位
 * @Date: 2019/11/19 11:23
 * @Version: 1.0
 */
public class Reverse {


    public static void main(String[] args) {
//            getBinary();
//            System.out.println("*****************");
//            int x = 12345;
//            System.out.println(Integer.toBinaryString(x));
//            System.out.println("*****************");
//            shuffle(x);
//        long x = Integer.parseInt("12",16);
//        System.out.println("8---" +Long.toBinaryString(x));
//        reverse2(x);
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(reverse(x)));
        System.out.println(-1/2);
    }

    private static int reverse(int x){
        x = (x & Integer.parseInt("55555555",16))<<1 | (x>>1) & Integer.parseInt("55555555",16);
        System.out.println(Integer.toBinaryString(x));
        x = (x & Integer.parseInt("33333333",16))<<2 | (x>>2) & Integer.parseInt("33333333",16);
        System.out.println(Integer.toBinaryString(x));
        x = (x & Integer.parseInt("0F0F0F0F",16))<<4 | (x>>4) & Integer.parseInt("0F0F0F0F",16);
        System.out.println(Integer.toBinaryString(x));
        x = (x<<24)|((x&Integer.parseInt("FF00",16))<<8) |
                ((x>>8)&Integer.parseInt("FF00",16))
                |(x>>24);
        return x;
    }

    /**
     * 先把相邻的两个交换，再把相邻的四个交换，然后是8个，然后是16个。
     * >> 优先于 |
     * @param x
     * @return
     */
    private static long reverse1(long x){
        x = (x&Integer.parseInt("55555555",16))<<1 | (x&Long.parseLong("AAAAAAAA",16))>>1;
        System.out.println("1-->55555555:" +Long.toBinaryString(x));
        x = (x&Integer.parseInt("33333333",16))<<2 | (x&Long.parseLong("CCCCCCCC",16))>>2;
        System.out.println("2-->33333333:" +Long.toBinaryString(x));
        x = (x&Integer.parseInt("0F0F0F0F",16))<<4 | (x&Long.parseLong("F0F0F0F0",16))>>4;
        System.out.println("3-->0F0F0F0F:" +Long.toBinaryString(x));
        x = (x&Integer.parseInt("00FF00FF",16))<<8 | (x&Long.parseLong("FF00FF00",16))>>8;
        System.out.println("4-->00FF00FF:" +Long.toBinaryString(x));
        x = (x&Integer.parseInt("0000FFFF",16))<<16 | (x&Long.parseLong("FFFF0000",16))>>16;
        return x;
    }

    private static void reverse2(long x){
        System.out.println("1-->55555555:" +Long.toBinaryString(x&Integer.parseInt("55555555",16)));
        System.out.println("2-->55555555:" +Long.toBinaryString((x&Integer.parseInt("55555555",16))<<1));
        System.out.println("3-->55555555:" +Long.toBinaryString((x&Long.parseLong("AAAAAAAA",16))));
        System.out.println("4-->55555555:" +Long.toBinaryString((x&Integer.parseInt("55555555",16))<<1 | (x&Long.parseLong("AAAAAAAA",16))));
        System.out.println("5-->55555555:" +Long.toBinaryString((x&Integer.parseInt("55555555",16))<<1 | (x&Long.parseLong("AAAAAAAA",16))>>1));
    }

    private static void getBinary(){
//        System.out.println("0x55555555-->" +Integer.toBinaryString(Integer.parseInt("55555555",16)));
//        System.out.println("0xAAAAAAAA-->" +Long.toBinaryString(Long.parseLong("AAAAAAAA",16)));
//        System.out.println("0x33333333-->" +Integer.toBinaryString(Integer.parseInt("33333333",16)));
//        System.out.println("0xCCCCCCCC-->" +Long.toBinaryString(Long.parseLong("CCCCCCCC",16)));
//        System.out.println("0x0F0F0F0F-->" +Integer.toBinaryString(Integer.parseInt("0F0F0F0F",16)));
//        System.out.println("0xF0F0F0F0-->" +Long.toBinaryString(Long.parseLong("F0F0F0F0",16)));
        System.out.println("0000FF00-->" +Integer.toBinaryString(Integer.parseInt("0000FF00",16)));
        System.out.println("FF0000FF-->" +Long.toBinaryString(Long.parseLong("FF0000FF",16)));
    }

    private static void shuffle(int x){
        System.out.println(Integer.toBinaryString(x&Integer.parseInt("0000FF00",16)));

        System.out.println(Integer.toBinaryString((x&Integer.parseInt("0000FF00",16))<<8));

        System.out.println(Integer.toBinaryString(x>>8));

        System.out.println(Integer.toBinaryString((x>>8)&Integer.parseInt("0000FF00",16)));

        System.out.println(Long.toBinaryString(x&Long.parseLong("FF0000FF",16)));

        System.out.println(Long.toBinaryString((x&Integer.parseInt("0000FF00",16))<<8 | (x>>8)&Integer.parseInt("0000FF00",16) | x&Long.parseLong("FF0000FF",16)));
    }
}
