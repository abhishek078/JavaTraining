package com.visa.training.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.ConcurrentLinkedQueue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListFilesTester {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the file name: ");
		String name = scn.next();
		
		System.out.println("Enter the path: ");
		String path = scn.next();
		
		ConcurrentLinkedQueue<String> q = new ConcurrentLinkedQueue<String>();
		q.add(path);
		List<String> l = Collections.synchronizedList(new ArrayList<String>());
		ListFiles fil1 = new ListFiles(name, l, q);
		fil1.start();
		ListFiles fil2 = new ListFiles(name, l, q);
		fil2.start();
		ListFiles fil3 = new ListFiles(name, l, q);
		fil3.start();
		ListFiles fil4 = new ListFiles(name, l, q);
		fil4.start();
		fil1.join();
		fil2.join();
		fil3.join();
		fil4.join();
		System.out.println(fil4.matches);
		scn.close();
	}

}
