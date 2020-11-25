package stack;

/**
 * @ProjectName: structure
 * @Package: stack
 * @ClassName: SampleArrayStack
 * @Author: zwj
 * @Description: 注释 数组实现栈
 * @Date: 2019/10/17 15:16
 * @Version: 1.0
 */
public class SampleArrayStack {


    public static int[]array;
    public static int count = 0;
    public static int size;

    public SampleArrayStack(int itemSize){
        this.array = new int[itemSize];
        this.size = itemSize;
    }


    public void push(int element){
        if(count == size){
            System.out.println("stack size out boundary exception!");
            return;
        }
        count ++;
        array[count-1] = element;

    }

    public int pop(){
        int recount = array[count-1];
        count --;
        return recount;
    }
}
