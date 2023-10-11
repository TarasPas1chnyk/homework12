package org.example.FourThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzzMultithreading {
    private int n;
    private int current;
    private Lock lock = new ReentrantLock();

    public FizzBuzzMultithreading(int n) {
        this.n = n;
        this.current = 1;
    }

    public void fizz() {
        while (current < n) {
            lock.lock();
            if (current % 3 == 0 && current % 5 != 0) {
                print("fizz");
            }
            lock.unlock();
        }
    }

    public void buzz() {
        while (current < n) {
            lock.lock();
            if (current % 3 != 0 && current % 5 == 0) {
                print("buzz");
            }
            lock.unlock();
        }
    }

    public void fizzBuzz() {
        while (current < n) {
            lock.lock();
            if (current % 3 == 0 && current % 5 == 0) {
                print("fizzbuzz");
            }
            lock.unlock();
        }
    }

    public void number() {
        while (current < n) {
            lock.lock();
            if (current % 3 != 0 && current % 5 != 0) {
                print(String.valueOf(current));
            }
            lock.unlock();
        }
    }

    public void print(String str) {
        System.out.print(str + "\n");
        current++;
    }

    public void start() {
        FizzBuzzMultithreading fizzBuzzMultithreading = new FizzBuzzMultithreading(n);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> fizzBuzzMultithreading.fizz());
        executor.execute(() -> fizzBuzzMultithreading.buzz());
        executor.execute(() -> fizzBuzzMultithreading.fizzBuzz());
        executor.execute(() -> fizzBuzzMultithreading.number());
        executor.shutdown();
    }
}