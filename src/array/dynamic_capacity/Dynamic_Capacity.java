package array.dynamic_capacity;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ProjectName: structure
 * @Package: array
 * @ClassName: Dynamic_Capacity
 * @Author: zwj
 * @Description: 注释 实现一个支持动态扩容的数组
 * @Date: 2019/10/15 15:35
 * @Version: 1.0
 */
public class Dynamic_Capacity {

    public static void main(String[] args) {
        int[] i = new int[2];
        i[0]=1;
        i[1]=20;
        for(int i1:i){
            System.out.println(i1);
        }
        System.out.println("*************");
        int[]j = get_new_array(i);
        for(int j1:j){
            System.out.println(j1);
        }
        System.out.println("*************");
        int[]k = get_new_array1(i);
        for(int k1:k){
            System.out.println(k1);
        }


    }

    public static int[] get_new_array(int[]old_arrays){
        int size = old_arrays.length;
        int[]new_array = new int[size*2];
        int size1 = 0;
        for(int old_array : old_arrays){
            new_array[size1]=old_array;
            size1++;
        }
        return new_array;
    }

    public static int[] get_new_array1(int[]old_arrays){
        int size = old_arrays.length;
        int[]new_array = Arrays.copyOf(old_arrays, size*2);
        return new_array;
    }
}
