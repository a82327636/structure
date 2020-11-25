package java_interview.concurrent;

import java.util.concurrent.*;

/**
 * @ProjectName: structure
 * @Package: java_interview.concurrent
 * @ClassName: ConcurrentTools
 * @Author: zwj
 * @Description: 注释 并发工具包
 * @Date: 2020/3/17 14:23
 * @Version: 1.0
 */
public class ConcurrentTools {

    // CountDownLatch // 允许一个或多个线程等待某些操作完成。
        // CountDownLatch 不可以重置，无法重用。 基本操作组合是countDown/await
        // 调用await的线程阻塞等待counDown足够的次数。


    // CyclicBarrier // 一种辅助性的同步结构，允许多个线程等待到达某个屏障。
        // CyclicBarrier 可以重用。基本操作就是 await,当所有的伙伴都调用了await,才会继续执行任务。
        // 会自动进行重置，如果我们调用reset方法，但还有线程在等待，则导致线程报错。
        // 典型应用场景时用来等待并发线程结束，侧重点是线程而不是调用事件。

        // 代码
        // CyclicBarrierSample


    // Semaphore // 信号量，通过控制一定数量的permit方式，达到限制通用资源访问的目的
        // Semaphore 就是个计数器，其基本逻辑基于 acquire/release

        // 代码
        // UsualSemaphoreSample
        // AbnormalSemphoreSample


    // 应用map时如果重视获取的速度，而不在乎顺序，推荐使用concurrentHashMap,反之 ConcurrentSkipListMap


    // CopyOnWrite 原理是：任何修改操作，都会拷贝原数组，修改后替换原来的数组，通过这种防御方式，实现另类的线程安全。
    // 适合读多写少的场景。（读取的时候可以不加锁）


    // concurrentLinkedQueue 这种Concurrent* 容器才真正代表并发
        // Concurrent 类型基于 lock-free(CAS 无锁机制),可以提高较高吞吐量。
    // linkedBlockingQueue 内部基于锁

    // concurrent 包提供的容器从命名分为：Concurrent*、CopyOnWrite、Blocking
       // Concurrent*没有类似CopyOnwrite之类容器相对较重的修改开销。
       // Concurrent 往往提供较低遍历性，就是所谓弱一致性。当利用迭代器遍历时，如果容器发生修改，迭代器仍然可以继续进行遍历.
       // 与弱一致性相反，同步容器常见行为“fail-fast”,检查到容器在遍历时发生了修改，则抛出异常。





//    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue();



}
