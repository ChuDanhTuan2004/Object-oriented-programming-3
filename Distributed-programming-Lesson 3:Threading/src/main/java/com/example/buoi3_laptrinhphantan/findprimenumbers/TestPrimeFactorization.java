package com.example.buoi3_laptrinhphantan.findprimenumbers;

public class TestPrimeFactorization {
    public static void main(String[] args) {
        int n = 50;

        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization(n);
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization(n);

        Thread thread1 = new Thread(lazyPrimeFactorization);
        Thread thread2 = new Thread(optimizedPrimeFactorization);

        thread1.start();
        thread2.start();
    }
}
