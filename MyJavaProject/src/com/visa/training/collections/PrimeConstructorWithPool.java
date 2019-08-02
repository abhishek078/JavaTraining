package com.visa.training.collections;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeConstructorWithPool {

	public static void main(String[] args) throws InterruptedException, Exception {
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Scanner scn = new Scanner(System.in);
		long[] range = new long[2];
 		System.out.println("Enter range 1: ");
 		for(int i=0;i<2;i++)
 			range[i] = scn.nextLong();
		
		CallablePrimeCounter p1 = new CallablePrimeCounter(range[0], range[1]);
		/*
		 * Thread t1 = new Thread(p1); t1.start();
		 */
		Future<Long> f1 = pool.submit(p1);
		
		System.out.println("Enter range 2: ");
 		for(int i=0;i<2;i++)
 			range[i] = scn.nextLong();
 		
		CallablePrimeCounter p2 = new CallablePrimeCounter(range[0], range[1]);
		/*
		 * Thread t2 = new Thread(p2); t2.start();
		 */
		Future<Long> f2 = pool.submit(p2);
		/*
		 * t1.join(); t2.join();
		 */
		
		long result1 = f1.get();
		long result2 = f2.get();
		
		System.out.println("The number of primes in range 1 are: "+result1);
		System.out.println("The number of primes in range 2 are: "+result2);
		
		System.out.println("Thread execution finished!!");
		pool.shutdown();
	}

}
