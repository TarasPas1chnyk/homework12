package org.example;


import org.example.FourThreads.FizzBuzzMultithreading;
import org.example.twothreads.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        new FizzBuzzMultithreading(15).start();
    }

}