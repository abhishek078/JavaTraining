package com.visa.training.collections;

import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.ConcurrentLinkedQueue;

public class ListFiles extends Thread {

	String fileName;
	List<String> matches;
	ConcurrentLinkedQueue<String> q;

	public ListFiles(String fileName, List<String> matches, ConcurrentLinkedQueue<String> q) {
		this.fileName = fileName;
		this.matches = matches;
		this.q = q;
	}

	@Override
	public void run() {
		//synchronized (this) {
			while (!q.isEmpty()) {
				String path = q.poll();
				File file = new File(path);
				for (File fl : file.listFiles()) {
					if (fl.isFile()) {
						if (fl.getName().equals(fileName)) {
							matches.add(fl.getAbsolutePath());
						}
					} else if (fl.isDirectory()) {
						q.add(fl.getAbsolutePath());
					}
				}
			}
		
	}

}
