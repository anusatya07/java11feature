package com.v2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;

public class Java12Methods {

	    public static void main(String[] args) throws IOException {
	    	//1. mismatch diff 2 files info
	    	Path filePath1 = Files.createTempFile("file1", ".txt");
	         Path filePath2 = Files.createTempFile("file2", ".txt");
	         Files.writeString(filePath1,"satish Test String");
	         Files.writeString(filePath2,"satish Test String");

	         long mismatch = Files.mismatch(filePath1, filePath2);

	         System.out.println("File Mismatch position... It returns -1 if there is no mismatch");

	         System.out.println("Mismatch position in file1 and file2 is >>>>");
	         System.out.println(mismatch);

	         filePath1.toFile().deleteOnExit();
	         filePath2.toFile().deleteOnExit();

	         System.out.println();

	         Path filePath3 = Files.createTempFile("file3", ".txt");
	         Path filePath4 = Files.createTempFile("file4", ".txt");
	         Files.writeString(filePath3,"Satish Test String");
	         Files.writeString(filePath4,"Satish.com Test String");

	         long mismatch2 = Files.mismatch(filePath3, filePath4);

	         System.out.println("Mismatch position in file3 and file4 is >>>>");
	         System.out.println(mismatch2);

	         filePath3.toFile().deleteOnExit();
	         filePath4.toFile().deleteOnExit();

	         //2.  NumberFormat
	         
	         System.out.println("Compact Formatting is:");
	         NumberFormat upvotes = NumberFormat
	                 .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
	         upvotes.setMaximumFractionDigits(1);

	         System.out.println(upvotes.format(2592) + " upvotes");


	         NumberFormat upvotes2 = NumberFormat
	                 .getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
	         upvotes2.setMaximumFractionDigits(2);
	         System.out.println(upvotes2.format(2011) + " upvotes");
	    	
	        //3. Teeing Collector
//	         double mean = Stream.of(1, 2, 3, 4, 5)
//	                 .collect(Collectors.teeing(
//	                         summingDouble(i -> i),
//	                         counting(),
//	                         (sum, n) -> sum / n));
//
//	        System.out.println(mean);

	}

}
