package com.example.buoi3_laptrinhphantan.findprimenumbers;

import java.util.ArrayList;

public class OptimizedPrimeFactorization implements Runnable {
    private int n;

    public OptimizedPrimeFactorization(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                System.out.println("OptimizedPrimeFactorization: " + i);
            }
        }
    }
}
