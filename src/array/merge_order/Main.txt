package array.merge_order;

/**
 * @ProjectName: structure
 * @Package: array.merge_order
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 实现两个有序数组合并为一个有序数组
 * @Date: 2019/10/15 15:44
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
//        Integer[] i = new Integer[]{1,3,5,6,8};
//        Integer[] j = new Integer[]{2,4,7,9};
//        Integer[] k = merge(i,j);
//        for(Integer k1:k){
//            if(k1 !=null){
//                System.out.println(k1);
//            }
//        }

        int[] i = new int[]{1,3,5,6,8,0,0,0,0};
        int[] j = new int[]{2,4,7,9};
        merge(i,5,j,4);
        for(int i1:i){
            System.out.println(i1);
        }
    }


//    public static Integer[] merge(Integer[]first_arrays,Integer[]second_arrays){
//        int first_array_index = first_arrays.length;
//        int second_array_index = second_arrays.length;
//        Integer[] merge_arrays = new Integer[first_array_index+second_array_index];
//        int merge_arrays_index = 0;
//        int second_array_next_index = 0;
//        for(int i = 0;i<=first_array_index-1;i++){
//            for(int j = second_array_next_index;j<=second_array_index-1;j++) {
//                if(first_arrays[i]>second_arrays[j]){
//                    merge_arrays[merge_arrays_index] = second_arrays[j];
//                    merge_arrays_index++;
//                    second_array_next_index++;
//                }else{
//                    merge_arrays[merge_arrays_index] = first_arrays[i];
//                    merge_arrays_index++;
//                    break;
//                }
//            }
//        }
//
//        return merge_arrays;
//    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        try{
            int len1 = m-1;
            int len2 = n-1;
            int len = m+n-1;
            while(len1 >= 0 && len2 >= 0) {
                nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
