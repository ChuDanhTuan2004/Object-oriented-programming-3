package com.example.buoi3_laptrinhphantan.enumthread;

public class EvenNumbersThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumbersThread evenThread = new EvenNumbersThread();
        evenThread.start();
    }
}
