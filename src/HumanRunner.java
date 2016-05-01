import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HumanRunner {
	public static void main(String[] args) {
		List<Human> human =
			    Arrays.asList(
			        new Human("Max", 18),
			        new Human("Peter", 23),
			        new Human("Pamela", 23),
			        new Human("David", 12));
		
		/**
		 * Collect is an extremely useful terminal operation to 
		 * transform the elements of the stream into a different
		 * kind of result, e.g. a List, Set or Map. 
		 * 
		 * Collect accepts a Collector which consists of four 
		 * different operations: a supplier, an accumulator, 
		 * a combiner and a finisher. This sounds super complicated 
		 * at first, but the good part is Java 8 supports 
		 * various built-in collectors via the Collectors class. 
		 * So for the most common operations you don't have to 
		 * implement a collector yourself.
		 */
		
		List<Human> newListHuman =
		human
		.stream()
		.filter(p -> p.name.startsWith("P"))
		.collect(Collectors.toList());
		
		System.out.println(newListHuman);
		System.out.println("");	

		//The next example groups all persons by age:
		Map<Integer, List<Human>> personByAge =
				human
				.stream()
				.collect(Collectors.groupingBy(p -> p.age));
		
		personByAge
		.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		
		System.out.println("");	
		List<Human> human1 =
			    Arrays.asList(
			        new Human("Max", 18),
			        new Human("Peter", 23),
			        new Human("Pamela", 12),
			        new Human("Peter", 34),
			        new Human("Pamela", 23),
			        new Human("David", 12));
		
		
		Map<String, List<Human>> personByName = 
				human1
				.stream()
				.collect(Collectors.groupingBy(p -> p.name));
		personByName
		.forEach((name, person) -> System.out.format("Name: %s\n",  person));
		
		System.out.println("");	

		
		Double averageAge = human1
			    .stream()
			    .collect(Collectors.averagingInt(p -> p.age));

			System.out.println("Average Age: " + averageAge);
			
		IntSummaryStatistics ageSummary =
				human1
				.stream()
				.collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);
		System.out.println("");	
		
		Integer ageSum = human1
			    .stream()
			    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

			System.out.println("sum of ages: "+ageSum);  
			System.out.println("");	

			
			System.out.println("");	

	}
}
