package com.visa.training.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class MyDOS {
	public static void main(String[] args) throws Exception {
		
		if(args[0].equals("dir")) {
			if(args.length>1) {
				File file = new File(args[1]);
				for(File fl : file.listFiles()) {
					System.out.println(fl.getName());
				}
			}
			else
			{
				File file = new File(System.getProperty("user.dir"));
				for(File fl : file.listFiles()) {
					System.out.println(fl.getName());
				}
			}
		}
		else if(args[0].equals("copy")) {
			
			long start = System.currentTimeMillis();
			File fileIn = new File(args[1]);
			File fileOut = new File(args[2]);
			
			FileInputStream fis = new FileInputStream(fileIn);
			FileOutputStream fos = new FileOutputStream(fileOut);
			
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int b;
			while((b = bis.read())!=-1) {
				bos.write(b);
			}
			fis.close();
			fos.close();
			bis.close();
			bos.close();
			
			long end = System.currentTimeMillis();
			long diff = end-start;
			System.out.println("Copying took "+diff+" milliseconds");
			
		}
		else if(args[0].contentEquals("type")) {
			File file = new File(args[1]);
			FileInputStream fis = new FileInputStream(file);
			int b;
			while((b = fis.read())!=-1) {
				System.out.print((char)b);
			}
			fis.close();
		}
		else {
			System.out.println("Invalid input!!");
		}
		//System.out.println(System.getProperty("user.dir"));
	}
}
