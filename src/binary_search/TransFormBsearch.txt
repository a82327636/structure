package binary_search;

/**
 * @ProjectName: structure
 * @Package: binary_search
 * @ClassName: TransFormBsearch
 * @Author: zwj
 * @Description: 注释 几种常见变形的二分查找 (因为会存在重复的值)
 * @Date: 2019/10/24 15:08
 * @Version: 1.0
 */
public class TransFormBsearch {

    // 1: 查找第一个值等于给定值的元素
    // 2: 查找最后一个值等于给定值的元素
    // 3: 查找第一个大于等于给定值的元素
    // 4: 查找最后一个小于等于给定值的元素


    /**
     *  1: 查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch1(int[]a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid =low+((high-low)>>1);
            if(a[mid]>value){
                high = mid - 1;
            }else if(a[mid]<value){
                low = mid+1;
            }else{ // 当等于值的时候，再判断一次附近的值是否也等于要查找的值
                /**
                 * mid == 0 表示这是第一个元素,那肯定是我们要找的元素
                 * a[mid-1]!=value,也说明mid就是我第一个元素，因为前面的值不等于value
                 */
                if((mid==0)||(a[mid-1]!=value))return mid;
                else high = mid-1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch2(int[]a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid =low+((high-low)>>1);
            if(a[mid]>value){
                high = mid - 1;
            }else if(a[mid]<value){
                low = mid+1;
            }else{ // 当等于值的时候，再判断一次附近的值是否也等于要查找的值
                /**
                 * mid == n-1 表示这是最后一个元素,那肯定是我们要找的元素
                 * a[mid+1]!=value,也说明mid就是最后一个元素，因为后面的值不等于value
                 */
                if((mid==n-1)||(a[mid+1]!=value))return mid;
                else low = mid+1;
            }
        }
        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch3(int[]a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid =low+((high-low)>>1);
            if(a[mid]>=value){
                /**
                 * 如果中间值大于等于给定值，则符合要求然后再判断是不是大于等于的第一个
                 * mid == 0表示第一个元素
                 * a[mid-1]<value 表示中间元素的前一个值小于给定值
                 */
                if((mid==0)||(a[mid-1]<value))return mid;
                else high = mid-1;
            }else if(a[mid]<value){
                low = mid+1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearch4(int[]a,int n,int value){
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid =low+((high-low)>>1);
            if(a[mid]>value){
                high = mid - 1;
            }else{
                /**
                 * mid == n-1 表示这是最后一个元素,那肯定是我们要找的元素
                 * a[mid+1]>value,也说明mid就是最后一个元素，因为后面的值>value
                 */
                if((mid==n-1)||(a[mid+1]>value))return mid;
                else low = mid+1;
            }
        }
        return -1;
    }

}
