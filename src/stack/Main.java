package stack;

/**
 * @ProjectName: structure
 * @Package: stack
 * @ClassName: Main
 * @Author: zwj
 * @Description: 注释 栈
 * @Date: 2019/10/17 14:31
 * @Version: 1.0
 */
public class Main {

    // 1: 用数组实现一个顺序栈
    // 2: 用链表实现一个链式栈
    // 3: 编程模拟实现一个浏览器的前进、后退功能


    public static void main(String[] args) {

        // 1:用数组实现一个顺序栈
//        SampleArrayStack sampleArrayStack = new SampleArrayStack(4);
//        sampleArrayStack.push(1);
//        sampleArrayStack.push(2);
//        sampleArrayStack.push(3);
//        sampleArrayStack.push(4);
//        for(int i = 0;i<4;i++){
//            System.out.println(sampleArrayStack.pop());
//        }

        // 2:用链表实现一个链式栈
//        SampleLinkStack sampleLinkStack = new SampleLinkStack();
//        sampleLinkStack.push(1);
//        sampleLinkStack.push(2);
//        sampleLinkStack.push(3);
//        sampleLinkStack.push(4);
//        for(int i = 0;i<4;i++){
//            System.out.println(sampleLinkStack.pop());
//        }

        // 3:编程模拟实现一个浏览器的前进、后退功能
        SampleBrowerNodeStack sampleBrowerNodeStack1 = new SampleBrowerNodeStack();
        SampleBrowerNodeStack sampleBrowerNodeStack2 = new SampleBrowerNodeStack();
        SampleBrowerStack sampleBrowerStack = new SampleBrowerStack(sampleBrowerNodeStack1,sampleBrowerNodeStack2);
        sampleBrowerStack.open("http://www.baidu.com");
        sampleBrowerStack.open("http://news.baidu.com/");
        sampleBrowerStack.open("http://news.baidu.com/ent");
        sampleBrowerStack.afterWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.forWard();
        sampleBrowerStack.open("http://www.qq.com");
        sampleBrowerStack.forWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.forWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.afterWard();
        sampleBrowerStack.checkCurrentPage();


    }
}
