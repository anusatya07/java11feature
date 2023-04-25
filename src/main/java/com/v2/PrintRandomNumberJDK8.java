package com.v2;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrintRandomNumberJDK8 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SecureRandom sRand = SecureRandom.getInstanceStrong();

		IntStream randStream = sRand.ints(5).sorted().sequential();
		randStream.forEach(System.out::println);
		
		Random random = new Random();

		//1
		IntStream randStream1 = random.ints(5);
		randStream1.forEach(System.out::println);

		//2
		DoubleStream doubleStream = random.doubles(5, 0, 0.5);
		doubleStream.forEach(System.out::println);
	}

}
