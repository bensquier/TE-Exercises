package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		
		System.out.println("Enter file or path to inspect");
		String path = userInput.nextLine();
		
		File file = new File(path);
		
		System.out.println(file.toString());

		if(file.exists()) {
			
			System.out.println("Name: " + file.getName());
			
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			
			if(file.isDirectory()) {
				System.out.println(path + " is a directory");
			}else if(file.isFile()) {
				System.out.println(path + "is a file");
			}
			
			System.out.println("size " + file.length());
			
		}
		else {
			System.out.println("I couldn't find that file:" + path);
		}
		
		System.out.println("What is the name of the New directory you want to create");
		String directory = userInput.nextLine();
		
		File newDirectory = new File(directory);
		
		if(newDirectory.exists()) {
			System.out.println("Sorry, I can not create that directory (" + directory + "), it already exists");
		}else {
			if(newDirectory.mkdir()) {
				System.out.println(directory + " was created");
			}else {
				System.out.println("Sorry could not create " + directory);
			}
		}
		
	}

}
