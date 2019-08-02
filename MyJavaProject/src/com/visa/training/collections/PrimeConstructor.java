package com.visa.training.collections;

public class PrimeConstructor implements Runnable {

	long start,end;
	static int t = 0;
	boolean isFinished = false;
	
	public PrimeConstructor(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		t++;
		System.out.println("Thread "+t+" started!");
		
		int count = 0;
		for(long i=start;i<=end;i++) {
			boolean flag = true;
			for(long j=2;j<=i/2;j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag)
				count++;
		}
		
		System.out.println(count);
		isFinished = true;
	}

}
