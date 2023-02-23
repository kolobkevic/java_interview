package ru.kolobkevic.homework.lesson_3.part_1;

public class PingPong {
    private final Object mon = new Object();
    private final String ping = "Ping ";
    private final String pong = "Pong";
    private boolean isPing = true;

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread thread1 = new Thread(pingPong::printPing);
        Thread thread2 = new Thread(pingPong::printPong);
        thread1.start();
        thread2.start();
    }

    private void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 20; i++) {
                    while (!isPing) {
                        mon.wait();
                    }
                    System.out.print(ping);
                    isPing = false;
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printPong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 20; i++) {
                    while (isPing) {
                        mon.wait();
                    }
                    System.out.println(pong);
                    isPing = true;
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
