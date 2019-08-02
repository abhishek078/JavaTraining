package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
	
	
	
	public static <T> List<T> allMatches(List<T> list, Predicate<T> str){
		List<T> l2 = new ArrayList<>();
		for(T lst : list) {
			if(str.test(lst)) {
				l2.add(lst);
			}
		}
		return l2;
	}
	
	public static <T, R> List<R> transformedList(List<T> list, Function<T,R> fun){
		List<R> l2 = new ArrayList<>();
		for(T lst : list) {
			l2.add(fun.apply(lst));		
		}
		return l2;
	}
	
	public static int eChecker(String s1, String s2) {
		if(s1.contains("e")&&!s2.contains("e"))
			return -1;
		else if(!s1.contains("e")&&s2.contains("e"))
			return 1;
		return 0;
	}
	
	public static <T> T betterElement(T s1, T s2, TwoElementPredicate<T> con) {
		if(con.isFirstBetter(s1, s2))
			return s1;
		else
			return s2;
	}
	
	public static void main(String[] args) {
		String[] words = {"this", "is", "a", "new", "sentence", "nice"};
		List<String> list = Arrays.asList(words);
		
		System.out.println("Before Sort:");
		System.out.println(list);
		
		System.out.println("After first sort:");
		Collections.sort(list,(s1,s2)->s1.length()-s2.length());
		System.out.println(list);
		
		System.out.println("After second sort:");
		Collections.sort(list,(s1,s2)->s2.length()-s1.length());
		System.out.println(list);
		
		System.out.println("After third sort:");
		Collections.sort(list,(s1,s2)->s1.charAt(0)-s2.charAt(0));
		System.out.println(list);
		
		System.out.println("After fourth sort:");
		Collections.sort(list,LambdaDemo::eChecker);
		System.out.println(list);
		
		Car car1 = new Car(10,"Mercedes");
		Car car2 = new Car(20,"Jaguar");
		Car c3 = betterElement(car1, car2, (c1,c2)->c1.getPrice()<c2.getPrice());
		String ans = betterElement("Hello","World",(s1,s2)->s1.length()>s2.length());
		System.out.println(c3.getName());
		System.out.println(ans);
		
		//List<String> words = Arrays.asList("New", "Sentence");
		List<String> sWords = allMatches(list,s->s.length()<4);
		System.out.println(sWords);
		
		List<Integer> nums = Arrays.asList(1,10,100,1000,10000);
		List<Integer> bigNum = allMatches(nums, n->n>5000);
		System.out.println(bigNum);
		
		List<String> excitingWords = transformedList(list,s->s+"!");
		System.out.println(excitingWords);
		
		List<Integer> wordLengths = transformedList(list, String::length);
		System.out.println(wordLengths);
		
	}

}
