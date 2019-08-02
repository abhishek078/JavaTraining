package com.visa.training.collections;

import java.util.concurrent.Callable;

public class CallablePrimeCounter implements Callable<Long>{
	
	long start,end;
	
	public CallablePrimeCounter(long start, long end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public Long call() throws Exception {
		long count = 0;
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
		return count;
	}

}
