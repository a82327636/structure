package study_result;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Formula1
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/11/18 11:42
 * @Version: 1.0
 */
public class Formula1 {

    public static void main(String[] args) {
        System.out.println(Long.parseLong("80808080",16));
        System.out.println(Integer.parseInt("7F7F7F7F",16));
        System.out.println(Long.toBinaryString(2155905152l));
        System.out.println(Integer.toBinaryString(2139062143));
        System.out.println(Integer.valueOf("01111111111111111111111111111111",2).toString());

        System.out.println("**********************");

        int x = 2139062143;
        System.out.println(Integer.toBinaryString(x&(x<<1)));
        System.out.println(Integer.toBinaryString(x&(x<<2)));
        System.out.println(Integer.toBinaryString(x&(x<<4)));
    }
}
