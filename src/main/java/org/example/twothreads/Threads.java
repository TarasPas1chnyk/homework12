package org.example.twothreads;

public class Threads {
    public synchronized static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; true; i++) {
                if (i % 5 != 0) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("минуло 5 сек" + " " + Thread.currentThread().getName());
            }
        });
        thread.start();

    }
}