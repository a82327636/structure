package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: BFmatching
 * @Author: zwj
 * @Description: 注释 BF算法匹配字符串
 * @Date: 2019/10/29 10:30
 * @Version: 1.0
 */
public class BFmatching {


    /**
     *
     * @param a 主串
     * @param b 模式串
     * 如 主串a是 aaaaaaaaa
     *    模式串b是 aab
     *    则每次都比对b个字符，要比较a-b+1次
     *
     * @return 匹配出现的首位置
     */
    public int bF(String a,String b) {
        int m=a.length(),n=b.length(),k;
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        for(int i=0;i<=m-n;i++) { // 当比较完成或者出现不匹配时，从下一个字符开始
            k=0;
            for(int j=0;j<n;j++) { // 一个字一个字的比较
                if(a1[i+j]==b1[j]) {
                    k++;
                }
                else
                    break;
            }
            if(k==n) {
                return i;
            }
        }
        return -1;
    }

}
