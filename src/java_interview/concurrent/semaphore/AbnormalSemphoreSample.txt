package java_interview.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @ProjectName: structure
 * @Package: java_interview.concurrent.semaphore
 * @ClassName: AbnormalSemphoreSample
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/3/17 14:41
 * @Version: 1.0
 */
public class AbnormalSemphoreSample {

    public static void main(String[] args)throws Exception {
        Semaphore semaphore = new Semaphore(0);
        for(int i=0;i<10;i++){
            Thread t = new Thread(new Mywork(semaphore));
            t.start();
        }
        System.out.println("Action ... go");
        semaphore.release(5);
        System.out.println("wait for permits off");
        while (semaphore.availablePermits()!=0){
            Thread.sleep(100l);
        }
        System.out.println("Action ... go again");
        semaphore.release(5);
    }


    static class Mywork implements Runnable{
        private Semaphore semaphore;
        public Mywork(Semaphore semaphore){
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try{
                semaphore.acquire();
                System.out.println("executed !");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
