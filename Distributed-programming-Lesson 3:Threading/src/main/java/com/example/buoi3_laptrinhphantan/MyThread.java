package com.example.buoi3_laptrinhphantan;

public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(2000);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
