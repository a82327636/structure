package study_result;

/**
 * @ProjectName: structure
 * @Package: study_result
 * @ClassName: Power
 * @Author: zwj
 * @Description: 注释 幂次方
 * @Date: 2019/11/13 16:39
 * @Version: 1.0
 */
public class Power {

    /**
     *
     * 判断是否是2的幂次方
     *
     * 对于这个问题，有三种方法；但是他们的中心思想都是二进制；
     *
     * 方法一：统计该数的二进制中1的个数；如果个数为1就是，否则就不是；
     *
     * 方法二：x == x&(-x) 由于x&(-x)返回的是从右到左第一个1所表示的大小； (可以获取最右侧且值为1的位)
     *       对于110010000 返回的就是 10000;所以可以用来判断；
     *
     * 方法三：x&(x-1)==0 举个例子：1000 它减1变成 0111 与运算得0 所以是2的幂次方；
     */


    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8|9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(8&-8)); // n&(-n)==n 表示n是2的幂次方
        System.out.println(Integer.toBinaryString(8&7)); // n&(n-1)==0 表示n是2的幂次方

        System.out.println((14&(4-1)) == 14%4 ? true:false);


        /**
         *
         * HashMap：为什么容量总是为2的次幂
         *
         * 因为 n 永远是2的次幂，所以 n-1 通过 二进制表示，永远都是尾端以连续1的形式表示（00001111，00000011）
         * 当(n - 1) 和 hash 做与运算时，会保留hash中 后 x 位的 1，
         * 例如 00001111 & 10000011 = 00000011
         *
         * 这样做有2个好处：
         *
         * &运算速度快，至少比%取模运算块 (hash算法找到key)
         *
         * 能保证"索引值"肯定在 capacity 中，不会超出数组长度 （因为 (n - 1) & hash 取到的key值是n-1最后的几位1所代表的值）
         *
         * (n - 1) & hash，当n为2次幂时，会满足一个公式：(n - 1) & hash = hash % n
         *
         * 如：
         * 14%4 等价于 14&(4-1)
         *
         * 结果都是等于2
         *
         * 计算过程
         * 14    1110
         * 3       11
         *
         * 1110 & 11=10 = 2
         *
         */


        /**
         * HashMap中的hash也做了比较特别的处理，(h = key.hashCode()) ^ (h >>> 16)。
         * 先获得key的hashCode的值 h，然后 h 和 h右移16位 做异或运算。
         * 实质上是把一个数的低16位与他的高16位做异或运算，因为在前面 (n - 1) & hash 的计算中，hash变量只有末x位会参与到运算。
         *  使高16位也参与到hash的运算能减少冲突。
         *
         * 例如1000000的二进制是
         *           00000000 00001111 01000010 01000000
         * 右移16位： 00000000 00000000 00000000 00001111
         * 异或      00000000 00001111 01000010 01001111
         * (先右移16位（把原高16位移动到低16位），原高16位与低16位异或)
         *
         * * 实质上是把一个数的低16位与他的高16位做异或运算，因为在前面 (n - 1) & hash 的计算中，hash变量只有末x位会参与到运算。
         *          *  使高16位也参与到hash的运算能减少冲突。
         */

        /**
         * capacity 永远都是 2 次幂，那么如果我们指定 initialCapacity 不为 2次幂时呢，是不是就破坏了这个规则？
         * 答案是不会的，HashMap的tableSizeFor方法做了处理，能保证n永远都是2次幂。
         *
         * static final int tableSizeFor(int cap) {
         *     //cap-1后，n的二进制最右一位肯定和cap的最右一位不同，即一个为0，一个为1，
         *       例如cap=17（00010001），n=cap-1=16（00010000）
         *     int n = cap - 1;
         *     // n = (00010000 | 00001000) = 00011000
         *     n |= n >>> 1;
         *
         *     //n = (00011000 | 00000110) = 00011110
         *     n |= n >>> 2;
         *
         *     //n = (00011110 | 00000001) = 00011111
         *     n |= n >>> 4;
         *
         *     // n = (00011111 | 00000000) = 00011111
         *     n |= n >>> 8;
         *
         *     // n = (00011111 | 00000000) = 00011111
         *     n |= n >>> 16;
         *
         *     // n = 00011111 = 31
         *     // n = 31 + 1 = 32, 即最终的cap = 32 = 2 的 (n=5)次方
         *     return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
         */

        System.out.println(Integer.toBinaryString(15));
        /**
         *               例如cap=16（00010000），n=cap-1=15（00001111）
         *          *     int n = cap - 1;
         *          *     // n = (00000111 | 00001111) = 00001111
         *          *     n |= n >>> 1;
         *          *
         *          *     //n = (00000011 | 00001111) = 00001111
         *          *     n |= n >>> 2;
         *          *
         *          *     //n = (00000000 | 00001111) = 00001111
         *          *     n |= n >>> 4;
         *          *
         *          *     // n = (00000000 | 00001111) = 00001111
         *          *     n |= n >>> 8;
         *          *
         *          *     // n = (00000000 | 00001111) = 00001111
         *          *     n |= n >>> 16;
         *          *
         *          *     // n = 00001111 = 15
         *          *     // n = 15 + 1 = 16, 即最终的cap = 16 = 2 的 (n=4)次方
         */
    }
}
