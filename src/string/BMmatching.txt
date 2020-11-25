package string;

/**
 * @ProjectName: structure
 * @Package: string
 * @ClassName: BMmatching
 * @Author: zwj
 * @Description: 注释 BM算法（坏字符规则与好字符规则）
 * @Date: 2019/10/29 11:31
 * @Version: 1.0
 */
public class BMmatching {

    private static final int SIZE = 256;

    /**
     *
     * @param b 模式串
     * @param m 模式串的长度
     * @param bc 散列表 存储模式串中的每个字符及其下标 （这里key是字符的ascii码，value是对应下标,重复的字符保留最后一次的位置）
     */
    private void generateBC(char[]b,int m,int[]bc){
        for(int i = 0;i<SIZE;i++){
            bc[i] = -1; //初始化BC
        }
        for(int i=0;i<m;i++){
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }

    public int bm(char[]a,int n,char[]b,int m){
        int[]bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b,m,bc);// 构建坏字符哈希表
        int i = 0;// i 表示主串与模式串对应的第一个字符
        while(i<=n-m){
            int j;
            for(j=m-1;j>=0;j--){ // 模式串从后往前匹配
                if(a[i+j]!=b[j])break;//坏字符对应模式串的下标是j
            }
            if(j<0){
                return i;//匹配成功，返回主串与模式串第一个匹配的字符位置
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i+(j-bc[(int)a[i+j]]);
        }
        return -1; //
    }

}
