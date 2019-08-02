package com.visa.training.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamsDemo {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "good", "morning");
		
		words.stream().forEach(s->System.out.println("  "+s));
		words.stream().forEach(System.out::println);

		List<String> excitingWords = words.stream().map(s->s+"!").collect(Collectors.toList());
			
		System.out.println(excitingWords);
		
		List<String> shortWords = words.stream().filter(s->s.length()<4).collect(Collectors.toList());
		System.out.println(shortWords);
		
		String upperw = words.stream().reduce((s1,s2)->s1.toUpperCase().concat(s2.toUpperCase())).orElse(null);
		System.out.println(upperw);
		
		String upper = words.stream().map(String::toUpperCase).reduce("", String::concat);
		System.out.println(upper);
		
		String comma = words.stream().reduce((s1,s2)->s1.concat(","+s2)).orElse(null);
		System.out.println(comma);
		
		double[] arr = new Random().doubles(100).toArray();
		
		//double[] arr1 = {1,4};
		double sum = DoubleStream.of(arr).map(Math::sqrt).sum();
		System.out.println(sum);
		
		double sump = DoubleStream.of(arr).parallel().map(Math::sqrt).sum();
		System.out.println(sump);
	}

}
