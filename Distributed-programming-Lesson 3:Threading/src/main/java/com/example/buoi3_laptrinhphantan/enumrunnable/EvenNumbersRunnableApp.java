package com.example.buoi3_laptrinhphantan.enumrunnable;

public class EvenNumbersRunnableApp {
    public static void main(String[] args) {
        EvenNumbersRunnable evenRunnable = new EvenNumbersRunnable();
        Thread evenThread = new Thread(evenRunnable);
        evenThread.start();
    }
}
