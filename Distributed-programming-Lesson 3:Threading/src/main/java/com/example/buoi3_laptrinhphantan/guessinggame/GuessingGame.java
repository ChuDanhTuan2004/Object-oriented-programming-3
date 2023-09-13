package com.example.buoi3_laptrinhphantan.guessinggame;

public class GuessingGame implements Runnable {
    private int guessNumber;
    private int count;
    boolean isWinner = false;

    public GuessingGame(int guessNumber) {
        this.guessNumber = guessNumber;
        this.count = 0;
    }

    @Override
    public void run() {
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(Thread.currentThread().getName() + " đoán số " + randomNumber);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (randomNumber != guessNumber);

        isWinner = true;
        System.out.println(Thread.currentThread().getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đoán");
    }
}
