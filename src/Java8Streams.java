import java.util.*;

public class Java8Streams {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		int result = 0;
		numbers.forEach(value-> System.out.println(value*2));
		
		for(int e: numbers)
			result += e *2;
		
		
		System.out.println(result);
		
		
		numbers.forEach(System.out::println);
		
		/**
		 * Streams in Java.
		 */
		
		System.out.println(
				numbers.stream()
				.map(e->e*2)
				.reduce(0, (c, e)->c+e)
				);
		
		
		List<Integer> numers2 = Arrays.asList(1,2,3,4,6,5,7,8,9,10);
		for(int e: numers2){
			if(e > 3 && e % 2 == 0){
				result = e *2;
				break;
			}
		}
		System.out.println(result);
		
		System.out.println(
				numbers.stream()
				.filter(e -> e > 3)
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.findFirst()
				);
		
		System.out.println(
				numbers.stream()
				.filter(Java8Streams::isGT3)
				.filter(Java8Streams::isEven)
				.map(Java8Streams::doubleIt)
				.findFirst());
					
	}	
	public static boolean isGT3(int number){
		System.out.println("is GT3 "  +number);
		return number >3;
	}
	public static boolean isEven(int number){
		System.out.println("is even "  +number);
		return number % 2 ==0;
	}
	public static int doubleIt(int number){		
		System.out.println("is Double "  +number);
		return number *2;
	}
	
}
