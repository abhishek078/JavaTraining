package com.visa.training.collections;

import java.util.Scanner;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scn = new Scanner(System.in);
		long[] range = new long[2];
 		System.out.println("Enter range 1: ");
 		for(int i=0;i<2;i++)
 			range[i] = scn.nextLong();
		
		PrimeConstructor p1 = new PrimeConstructor(range[0], range[1]);
		Thread t1 = new Thread(p1);
		t1.start();
		
		System.out.println("Enter range 2: ");
 		for(int i=0;i<2;i++)
 			range[i] = scn.nextLong();
 		
		PrimeConstructor p2 = new PrimeConstructor(range[0], range[1]);
		Thread t2 = new Thread(p2);
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("Thread execution finished!!");
		
	}

}
