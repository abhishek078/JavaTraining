package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
		return s1.length() - s2.length();
	}
	
}

public class CollectionsDemo {
	
	public static void demoGenerics() {
		
		List<Integer> iList1 = new ArrayList<>();
		List<Integer> iList2 = new ArrayList<>();
		List<String> sList1 = new ArrayList<>();
		List<String> sList2 = new ArrayList<>();
		List<Number> nList = new ArrayList<>();
		
		copyFirstListToSecond(iList1, iList2); 
		copyFirstListToSecond(sList1, sList2); 
		//copyFirstListToSecond(iList1, sList2); 
		copyFirstListToSecond(iList1, nList);
	}
	
	public static <T> void copyFirstListToSecond(List<T> source, List<? super T> dest) {
		
		for(T aNum : source) {
			dest.add(aNum);
		}
	}
	
	public static <T> T findHighest(List<T> l) {
		
		 
		
		return null;
	}

	public static void main(String[] args) {
		/*
		 * List<Double> doubles = demoList();
		 * 
		 * double sum = arraySum(doubles); System.out.println(sum);
		 */

		// demoMap();
		demoSortList();
		//demoSet();
	}

	private static void demoSortList() {
		String[] array = {"this", "is", "an", "array", "with", "unusual", "words", "like", "xylophone"};
		List<String> words = Arrays.asList(array);
		System.out.println("Before Sort:");
		System.out.println(words);
		System.out.println("After sort:");
		//Collections.sort(words,new StringLengthComparator());
		Collections.sort(words,  new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				
				return s1.length() - s2.length();
			}
		});
		System.out.println(words);
		
	}

	private static void demoSet() {
		Set<String> words = new TreeSet<>();
		while (true) {
			String aWord = fromKeyboard("Enter a word: ");
			if (!words.add(aWord)) {
				System.out.println("That's a duplicate!");
			}
			if (words.size() == 10) {
				break;
			}
		}
		System.out.println("____________List of unique words___________");
		for (String aWord : words) {
			System.out.println(aWord);
		}

	}

	private static void demoMap() {
		Map<String, String> employees = new HashMap<>();
		employees.put("e001", "emp1");
		employees.put("e002", "emp2");
		employees.put("e003", "emp3");
		employees.put("e004", "emp4");

		while (true) {
			String id = fromKeyboard("Enter an employee id (or 'quit') :");
			if (id.equalsIgnoreCase("quit")) {
				break;
			}
			if (employees.containsKey(id)) {
				System.out.println("Employee exists");
				System.out.println(employees.get(id));
			} else {
				System.out.println("No suchc employee exists");
			}
		}
		Set<String> keys = employees.keySet();
		for (String aKey : keys) {
			System.out.println(aKey + "--->" + employees.get(aKey));
		}
		// System.out.println();
	}

	private static String fromKeyboard(String string) {
		Scanner s = new Scanner(System.in);
		System.out.println(string);

		return s.nextLine();
	}

	private static double arraySum(List<? extends Number> num) {

		double sum = 0.0;
		for (Number aNumber : num) {
			sum += aNumber.doubleValue();
		}
		return sum;
	}

	private static List<Double> demoList() {
		List<Double> randoms = new ArrayList<Double>();

		while (true) {
			double aRandom = Math.random();
			if (aRandom < 0.01) {
				break;
			}
			randoms.add(aRandom);
		}
		System.out.println("The number of random numbers are " + randoms.size());

		/*
		 * Iterator<Double> it = randoms.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */

		for (Double aDouble : randoms) {
			System.out.println(aDouble);
		}
		return randoms;
	}

}
