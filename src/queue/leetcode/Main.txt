package queue.leetcode;

/**
 * @ProjectName: structure
 * @Package: queue.leetcode
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/10/18 14:33
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {

        // 1:双端循环队列
//        MyCircularQueue circularDeque = new MyCircularQueue(3); // 设置容量大小为3
////        System.out.println(circularDeque.insertLast(1));			        // 返回 true
////        System.out.println(circularDeque.insertLast(2));			        // 返回 true
////        System.out.println(circularDeque.insertFront(3));			        // 返回 true
////        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
////        System.out.println(circularDeque.getRear());  				// 返回 2
////        System.out.println(circularDeque.isFull());				        // 返回 true
////        System.out.println(circularDeque.deleteLast());			        // 返回 true
////        System.out.println(circularDeque.insertFront(4));			        // 返回 true
////        System.out.println(circularDeque.getFront());				// 返回 4


        // 2:滑动窗口最大值
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] outputs = maxSlidingWindow.maxSlidingWindow(nums,3);
        StringBuffer sbf = new StringBuffer();
        for(int output:outputs){
            sbf.append(output).append(",");
        }
        System.out.println(sbf.toString());
    }
}
