package com.visa.training;

public class FixedArrayStack implements Stack {

		int array[] = new int[100];
		int top = 0;
	@Override
	public void push(int element) {
		if(top==101)
		{
			System.out.println("Overflow");
			return;
		}
		array[top] = element;
		top ++;

	}

	@Override
	public Object pop() {
		top--;
		if(top<=-1)
			System.out.println("Underflow");
		else
			System.out.println(array[top]);
		
		return null;
	}

}
