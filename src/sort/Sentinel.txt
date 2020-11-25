package sort;

/**
 * @ProjectName: structure
 * @Package: sort
 * @ClassName: Sentinel
 * @Author: zwj
 * @Description: 注释 哨兵机制
 * @Date: 2019/10/22 17:34
 * @Version: 1.0
 */
public class Sentinel {

    // 不使用哨兵的情况
    public int find(int[]a,int n,int key){
        if(n<=0)return -1;
        int i = 0;
        while(i<n){
            if(a[i] == key){
                return i;
            }
            ++i;
        }
        return -1;
    }

    // 使用哨兵的情况
    public int find1(int[]a,int n,int key){
        if(n<=0)return -1;
        if(a[n-1]==key){ //新增这一步，是为了使用a[n-1]这个位置
            return n-1;
        }
        int tmp = a[n-1];
        a[n-1]=key; // 把key值放入a[n-1]的位置
        int i = 0;
        while(a[i] != key){ // 比上面的方法，在循环中少一个判断
            i++;
        }


        if(i == n-1){
            return -1; // 说明没有查到
        }else{
            return i;
        }

    }
}
