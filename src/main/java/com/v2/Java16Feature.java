package com.v2;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java16Feature {

	public static void main(String[] args) {
		// 1.
		Object obj = new  Object();
		//obj  getObject logic
		if (obj instanceof String) {
		  String s = (String) obj;
		  if (s.length() > 5) {
		    System.out.println(s.toUpperCase());
		  }
		} else if (obj instanceof Integer) {
		  Integer i = (Integer) obj;
		  System.out.println(i * i);
		}
		
		// 2.
		if (obj instanceof String s) {          // <-- implicit cast to String s
			  if (s.length() > 5) {
			    System.out.println(s.toUpperCase());
			  }
			} else if (obj instanceof Integer i) {  // <-- implicit cast to Integer i
			  System.out.println(i * i);
			}
		
		//3. Stream.of
		
		// ArrayList:
		Stream.of("foo", "bar", "baz").collect(Collectors.toList());

		// ImmutableCollections$ListN:
		Stream.of("foo", "bar", "baz").collect(Collectors.toUnmodifiableList());

		// LinkedList:
		Stream.of("foo", "bar", "baz").collect(Collectors.toCollection(LinkedList::new));
	
		// 4. we get Compiler error
		
		/*
		 * private void processObject(Object obj) { String s = "Hello, world"; if (obj
		 * instanceof String s) { // Compiler error // ... } }
		 */
	}
	// 5. Record concept
	/*
	 *-> A record can neither extend a class nor it can be extended by another class.
	 *-> It’s a final class. Records cannot be abstract Records cannot extend any
	 *   other class and cannot define instance fields inside the body.
	 *-> Instance fields must be defined in the state description only Declared fields are
	 *   private and final The body of a record allows static fields and methods
	 */
	record Author (int id, String name, String topic) {
	    static int followers;

	    public static String followerCount() {
	        return "Followers are "+ followers;
	    }

	    public String description(){
	        return "Author "+ name + " writes on "+ topic;
	    }

	    public Author{
	    if (id < 0) {
	        throw new IllegalArgumentException( "id must be greater than 0.");
	     }
	   }
	}
	
	//6. record support multiple constructore
	record Author1(String name, String topic) {
		  public Author1() {

		    this("NA", "NA");
		  }

		  public Author1(String name) {

		    this(name, "NA");
		  }
		}
  
	//7. mapMulti 
	List<Integer> list = stream
	        .mapMulti(
	            (List<Integer> numbers, Consumer<Integer> consumer) ->
	                numbers.forEach(number -> consumer.accept(number)))
	        .toList();
	//7.2 
//	List<Order> allOrders = customers.stream()
//	        .mapMulti(
//	            (Customer customer, Consumer<Order> consumer) ->
//	                customer.getOrders().forEach(consumer))
//	        .toList();
	
}
