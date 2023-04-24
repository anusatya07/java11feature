package com.v2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Java11Methods {

	public static void main(String[] args) throws IOException {
		System.out.println(" ".isBlank()); // true
	
		//1. isBlank method
		String s = "Satish";
		System.out.println(s.isBlank()); // false
		String s1 = "";
		System.out.println(s1.isBlank()); // true
	
		//2. lines method
		String str = "satish\nsanap\npune";
		System.out.println(str);
		System.out.println(str.lines().collect(Collectors.toList()));
		
		//3. strip method removed spaces before and after
        String string = " JD "; 
        System.out.print("Start");
        System.out.print(string.strip());
        System.out.println("End");
        
       //4. stripLeading method removed spaces  before string
        System.out.print("Start");
        System.out.print(string.stripLeading());
        System.out.println("End");
        
		// 5. stripTrailing method removed spaces after String
		System.out.print("Start");
		System.out.print(string.stripTrailing());
		System.out.println("End");

		// 6. repeat method create given number
		str = "=".repeat(2);
		System.out.println(str);
		
		//7-1>. Reading/Writing Strings to and from the Files
//		Path path;
//		String str1="";
//		try {
//			path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on Satish");
//		System.out.println(path);
//			 str1 = Files.readString(path);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(str1); //This was posted on Satish
		
		//7-2> create file 
		Path path=Path.of("satish.yaml");
		String str2=" satish sanap here provided file names and asked trip details ";
		try {
			Files.writeString(path, str2) ;
			System.out.println("Data is inserted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str3=Files.readString(path);
		System.out.println("File Informartions ");
		System.out.println(str3);
	}

}
