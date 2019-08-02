package com.visa.training;

public class StackApp {

	public static void main(String[] args) {
		StackUser su = new StackUser();
		FixedArrayStack fas = new FixedArrayStack();
		
		su.fill(fas);
		su.empty(fas);

	}

}
