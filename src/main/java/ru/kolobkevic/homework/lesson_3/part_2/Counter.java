package ru.kolobkevic.homework.lesson_3.part_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    public static void main(String[] args) {
        SimpleCounter simpleCounter = new SimpleCounter();
        Lock lock = new ReentrantLock();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    simpleCounter.increaseCounter();
                    System.out.printf("Thread %d increased counter. Counter = %d \n", num, simpleCounter.counter);
                } finally {
                    lock.unlock();
                }
            });
            threadList.add(thread);
        }

        for (int i = 10; i > 0; i--) {
            int num = i;
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    simpleCounter.decreaseCounter();
                    System.out.printf("Thread %d decreased counter. Counter = %d \n", num, simpleCounter.counter);
                } finally {
                    lock.unlock();
                }
            });
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.start();
        }
    }

    static class SimpleCounter {
        private int counter = 0;

        private void increaseCounter() {
            counter++;
        }

        private void decreaseCounter() {
            counter--;
        }
    }
}
