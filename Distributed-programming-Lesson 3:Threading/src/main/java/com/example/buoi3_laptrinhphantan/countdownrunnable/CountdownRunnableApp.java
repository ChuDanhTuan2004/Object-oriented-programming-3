package com.example.buoi3_laptrinhphantan.countdownrunnable;

public class CountdownRunnableApp {
    public static void main(String[] args) {
        CountdownRunnable countdownRunnable = new CountdownRunnable();
        Thread countdownThread = new Thread(countdownRunnable);
        countdownThread.start();
    }
}
