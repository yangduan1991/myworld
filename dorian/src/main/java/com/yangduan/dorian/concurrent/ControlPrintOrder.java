package com.yangduan.dorian.concurrent;

public class ControlPrintOrder {

    public static class PrintThread implements Runnable {

        private String[] strings;
        private Object lock;

        public PrintThread(String[] strings, Object lock) {
            this.strings = strings;
            this.lock = lock;
        }

        @Override
        public void run() {
            for(String s: strings) {
                synchronized (lock) {
                    System.out.print(s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        final Object lock = new Object();
        PrintThread t1 = new PrintThread(new String[]{"1", "2", "3", "4", "5", "6", "7"}, lock);
        PrintThread t2 = new PrintThread(new String[]{"a", "b", "c", "d", "e", "f", "g"}, lock);
        new Thread(t1).start();
        new Thread(t2).start();

    }

}
