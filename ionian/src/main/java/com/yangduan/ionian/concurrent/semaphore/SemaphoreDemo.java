package com.yangduan.ionian.concurrent.semaphore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.function.Supplier;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        MyThread t1 = new MyThread(1, semaphore);
        MyThread t2 = new MyThread(2, semaphore);
        MyThread t3 = new MyThread(3, semaphore);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();

    }

    private static class MyThread implements Runnable {
        private ThreadLocal<DateFormat> dateFormt;
        private int id;
        private Semaphore semaphore;

        public MyThread(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
            dateFormt = new ThreadLocal<>();
            dateFormt = ThreadLocal.withInitial(() -> new SimpleDateFormat("YYYY-MM-DD hh:mm:ss"));
        }

        @Override
        public void run() {
            while (true) {
                if (semaphore.tryAcquire()) {
                    System.out.println(id + " is running at " + dateFormt.get().format(new Date()));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }
            }
        }
    }

}
