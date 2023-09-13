package com.example.buoi3_laptrinhphantan.guessinggame;

import java.util.Scanner;

public class GuessingGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập một số nguyên từ 1 đến 100:");
        int guessNumber = scanner.nextInt();
        scanner.close();

        GuessingGame game1 = new GuessingGame(guessNumber);
        GuessingGame game2 = new GuessingGame(guessNumber);

        Thread thread1 = new Thread(game1, "Thread 1");
        Thread thread2 = new Thread(game2, "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (game1.isWinner) {
            System.out.println("Thread 1 là người chiến thắng!");
        } else if (game2.isWinner) {
            System.out.println("Thread 2 là người chiến thắng!");
        } else {
            System.out.println("Không có người chiến thắng!");
        }
    }
}
