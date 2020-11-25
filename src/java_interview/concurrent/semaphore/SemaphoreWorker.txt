package java_interview.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @ProjectName: structure
 * @Package: java_interview.concurrent.semaphore
 * @ClassName: SemaphoreWorker
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/3/17 14:31
 * @Version: 1.0
 */
public class SemaphoreWorker implements Runnable {

    private String name;
    private Semaphore semaphore;
    public SemaphoreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            log("is waiting for a permit");
            semaphore.acquire();
            log("acquire a permit!");
            log("executed!");
        }catch (InterruptedException e){
            e.fillInStackTrace();
        }finally {
            log("released a permit!");
            //semaphore.release();
        }
    }

    private void log(String msg){
        if(name == null){
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " +msg);
    }
}
