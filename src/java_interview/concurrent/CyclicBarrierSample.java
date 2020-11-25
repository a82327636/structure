package java_interview.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @ProjectName: structure
 * @Package: java_interview.concurrent
 * @ClassName: CyclicBarrierSample
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/3/17 15:03
 * @Version: 1.0
 */
public class CyclicBarrierSample {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action .... GO again");
            }
        });
        // CyclicWorker 线程可以重用，线程中的变量值都可以继续使用
        for (int i=0;i<3;i++){
            Thread thread = new Thread(new CyclicWorker(cyclicBarrier));
            thread.start();
        }

    }

    static class CyclicWorker implements Runnable{

        private CyclicBarrier cyclicBarrier;
        public CyclicWorker(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            // 一个线程进来后，循环了一次就等待其他线程（根据 CyclicBarrier 设置的parties）,然后所有线程
            // 都调用了await后，每个线程再继续执行(继续循环)。
            try{
                int j = 0;
                System.out.println("j="+j++);
                for(int i=0;i<2;i++){
                    System.out.println("Executed !" + Thread.currentThread().getName() + "I="+i);
                    cyclicBarrier.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
