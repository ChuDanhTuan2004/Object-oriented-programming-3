package com.example.buoi3_laptrinhphantan.showevenandoddnumbers;

public class OddThread extends Thread{
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
