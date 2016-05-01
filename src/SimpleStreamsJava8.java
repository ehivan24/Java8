import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author edwingsantos
 *
 */
public class SimpleStreamsJava8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		/**
		 * Streams are intermediate or terminal operations
		 * filter, map and sorted are intermediate operations 
		 * whereas forEach is a terminal operation
		 */
		
		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(System.out::println);
	
		System.out.println("");
		Stream.of("a1", "a2", "a3")
	    .findFirst() //prints out the first element = a1
	    .ifPresent(System.out::println); 
		
		System.out.println("");
		Arrays.asList("a1", "a2", "a3")
	    .stream()
	    .findFirst()  //prints out the first element = a1
	    .ifPresent(System.out::println);  
		
		System.out.println("");
		//IntStreams can replace the regular for-loop utilizing IntStream.range():
		IntStream.range(1, 4)
	    .forEach(System.out::println);
		System.out.println("");
		
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1) // 3 + 5 + 7 = 15 / 3  
	    .average()
	    .ifPresent(System.out::println);  // 5.0
		System.out.println("");
		
		
		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);  // 3
		
		System.out.println("");
		
		//Primitive streams can be transformed to object streams via mapToObj():
		
		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);

		System.out.println("");
		
		
		//the stream of doubles is first mapped to an int stream 
		//and than mapped to an object stream of strings
		
		Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);

		System.out.println("");

		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("");
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		
		System.out.println("");
		
		//As you might have guessed both map and filter are called 
		//five times for every string in the underlying 
		//collection whereas forEach is only called once.
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));


		System.out.println("");

		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	
		System.out.println("");	
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
	}

}
