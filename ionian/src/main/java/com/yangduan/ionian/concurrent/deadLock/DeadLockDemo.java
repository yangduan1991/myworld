package com.yangduan.ionian.concurrent.dealLock;

public class DeadLockDemo {

    private static final Object OBJECT_1 = new Object();
    private static final Object OBJECT_2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
        System.out.println("master thread is exiting");
        System.exit(0);
    }

    private static Runnable runnable1 = () -> {
        synchronized (OBJECT_1) {
            try {
                Thread.sleep(1000);
                System.out.println("ready to lock object2");
                synchronized (OBJECT_2) {
                    System.out.println("1111111111111");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private static Runnable runnable2 = () -> {
        synchronized (OBJECT_2) {
            try {
                Thread.sleep(1000);
                System.out.println("ready to lock object1");
                synchronized (OBJECT_1) {
                    System.out.println("222222222222222");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
