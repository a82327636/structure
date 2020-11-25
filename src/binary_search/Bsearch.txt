package binary_search;

/**
 * @ProjectName: structure
 * @Package: binary_search
 * @ClassName: Bsearch
 * @Author: zwj
 * @Description: 注释 有序数组二分查找
 * @Date: 2019/10/24 11:16
 * @Version: 1.0
 */
public class Bsearch {

    /**
     * 循环实现
     * @param a 数组a
     * @param n 数组大小
     * @param value 要查的数
     * @return
     */
    public int bseach(int[]a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low<=high){
            //int mid = low+(high-low)/2;
            int mid = low+((high-low)>>1);
            if(a[mid] == value){
                return mid;
            }else if(a[mid] < value){
                low = mid+1;
            }else{
                high= mid-1;
            }
        }
        return -1;
    }



    // 递归实现
    public int bseach1(int[]a,int low,int high,int value){
        if(low>high)return -1;

        int mid = low+((high-low)>>1);
        if(a[mid] == value){
            return mid;
        }else if(a[mid] < value){
           return bseach1(a,mid+1,high,value);
        }else{
           return bseach1(a,low,mid-1,value);
        }
    }
}
