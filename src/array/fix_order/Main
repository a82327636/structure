package array.fix_order;

/**
 * @ProjectName: structure
 * @Package: array.fix_order
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 实现一个大小固定的有序数组，支持动态增删改操作
 * @Date: 2019/10/15 15:43
 * @Version: 1.0
 */
public class Main {

    private static int CAPACITY = 0;

    public static void main(String[] args) {
        Integer[]i = new Integer[10];
        add(i,2);
        add(i,3);
        add(i,10);
        add(i,5);
        add(i,4);
        for(Integer i1:i){
            if(i1 !=null){
                System.out.println(i1);
            }
        }
        System.out.println("*********************");

        remove(i,2);
        for(Integer i1:i){
            if(i1 !=null){
                System.out.println(i1);
            }
        }

        System.out.println("*********************");
        modify(i,3,1);
        for(Integer i1:i){
            if(i1 !=null){
                System.out.println(i1);
            }
        }
    }

    public static void add(Integer[]arrays,int newElement){
        int index = arrays.length-1;
        int j;
        for(j=0;j<index;j++){
            if(arrays[j]==null || arrays[j]>newElement){
                break;
            }
        }
        for(int i = CAPACITY-1;i>=j;i--){
            if(arrays[i]!=null){
                arrays[i+1]=arrays[i];
            }
        }
        arrays[j]=newElement;
        CAPACITY ++;
        return;

    }

    public static void remove(Integer[]arrays,int elementIndex){
        if(elementIndex>CAPACITY-1){
            System.out.println("elementIndex beyond array boundary!");
            return;
        }
        for(int i = elementIndex;i<=CAPACITY-2;i++){
            arrays[i]= arrays[i+1];
        }
        arrays[CAPACITY-1]=null;
        CAPACITY--;
        return;
    }

    public static void modify(Integer[]arrays,int elementIndex,int newExement){
        if(elementIndex>CAPACITY-1){
            System.out.println("elementIndex beyond array boundary!");
            return;
        }
        arrays[elementIndex] = newExement;
        for(int i = 0;i<=CAPACITY-1;i++){
            Integer temp = 0;
            for(int j = i+1 ; j<=CAPACITY-1;j++){
                if(arrays[i]>arrays[j]){
                    temp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
        return;
    }
}
