package java_interview.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @ProjectName: structure
 * @Package: java_interview.concurrent.semaphore
 * @ClassName: UsualSemaphoreSample
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/3/17 14:31
 * @Version: 1.0
 */
public class UsualSemaphoreSample {

    public static void main(String[] args) {
        System.out.println("Action ... go");
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<10;i++){
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }

}
