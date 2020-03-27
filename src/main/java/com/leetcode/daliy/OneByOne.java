package com.leetcode.daliy;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author TSN
 * @date 2020/3/26
 * @Description
 */
class DataShare {
    private int single = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();

    public void get() throws InterruptedException {
        lock.lock();
        try {
            while (single <= 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "-->single :" + single);
            single--;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void put() throws InterruptedException {
        lock.lock();
        try {
            while (single >= 5) {
                condition.await();
            }
            single++;
            System.out.println(Thread.currentThread().getName() + "-->single :" + single);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (single != 0) {
                conditionA.await();
            }
            System.out.println("AAA");
            single = 1;
            conditionB.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (single != 1) {
                conditionB.await();
            }
            System.out.println("BBB");
            single = 2;
            conditionC.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (single != 2) {
                conditionC.await();
            }
            System.out.println("CCC");
            single = 3;
            conditionD.signal();
        } finally {
            lock.unlock();
        }
    }

    public void printD() throws InterruptedException {
        lock.lock();
        try {
            while (single != 3) {
                conditionD.await();
            }
            System.out.println("DDD");
            single = 0;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}

class ProAndCons {
    BlockingQueue<Integer> blockingQueue = null;
    private volatile Boolean flag = true;
    private volatile Boolean con = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public ProAndCons(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void pro() {
        int i;
        String s;
        while (flag) {
            try {
                i = atomicInteger.incrementAndGet();
                s = blockingQueue.offer(i, 2, TimeUnit.SECONDS) ? "成功" : "失败";
                System.out.println(Thread.currentThread().getName() + "==>放入" + i + s);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("flag is " + flag);
    }

    public void cons() {
        Integer poll;
        while (con) {
            try {
                poll = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (poll == null) {
                    System.out.println("不在等待,->");
                    con=false;
                }
                System.out.println(Thread.currentThread().getName() + "==>拿出:" + poll);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        this.flag = false;
    }
}

public class OneByOne {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 4, 2, TimeUnit.SECONDS, workQueue, Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        System.out.println('a'-'A'+0);
//        ProAndCons proAndCons = new ProAndCons(new LinkedBlockingDeque<>(10));
//        threadPoolExecutor.execute(proAndCons::pro);
//        threadPoolExecutor.execute(proAndCons::cons);
//
//        TimeUnit.SECONDS.sleep(10);
//        proAndCons.stop();
//        threadPoolExecutor.shutdown();
//        DataShare dataShare = new DataShare();
//        one2Five(dataShare);
//        printABCD(dataShare);

    }

    private static void printABCD(DataShare dataShare) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    dataShare.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A->").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    dataShare.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B->").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    dataShare.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C->").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    dataShare.printD();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D->").start();
    }

    private static void one2Five(DataShare dataShare) {
        new Thread(() -> {
            for (; ; ) {
                try {
                    dataShare.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "AA").start();
        new Thread(() -> {
            for (; ; ) {
                try {
                    dataShare.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (; ; ) {
                try {
                    dataShare.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "CC").start();
        new Thread(() -> {
            for (; ; ) {
                try {
                    dataShare.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}

