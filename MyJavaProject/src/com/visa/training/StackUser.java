package com.visa.training;

public class StackUser {

	public void fill(Stack s) {
		for(int i=0;i<10;i++) {
			s.push(i+1);
			System.out.println(i+1);
		}
	}
	
	public void empty(Stack s) {
		for(int i=0;i<10;i++) {
			s.pop();
			
		}
	}
	
}
