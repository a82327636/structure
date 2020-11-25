package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: RKmatching
 * @Author: zwj
 * @Description: 注释 RK 匹配算法
 *
 * RK算法是bf算法的改造,对每个子串分别求哈希值，然后拿子串的哈希值与模式串的哈希值比较，减少比较时间
 *
 * @Date: 2019/10/29 10:50
 * @Version: 1.0
 */
public class RKmatching {

    /**
     *
     * @param a 主串
     * @param b 模式串
     * @return
     */
    public int rK(String a,String b) {
        int m=a.length(),n=b.length(),s,j;
        int[] hash=new int[m-n+1];
        int[] table=new int[26]; // 使用26进制
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        s=1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for(j=0;j<26;j++) {
            table[j]=s;
            s*=26;
        }
        for(int i=0;i<=m-n;i++) {
            s=0;
            for(j=0;j<n;j++) {
                s+=(a1[i+j]-'a')*table[n-1-j]; // 子串生成哈希值(重点算法)
            }
            hash[i]=s;
        }
        s=0;
        for(j=0;j<n;j++) { // 模式串生成哈希值
            s+=(b1[j]-'a')*table[n-1-j];
        }
        for(j=0;j<m-n+1;j++) { // 哈希值比较
            if(hash[j]==s) {
                return j;
            }
        }
        return -1;
    }
}
