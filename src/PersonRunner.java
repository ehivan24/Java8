import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author edwingsantos
 *
 */
public class PersonRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		Person person = new Person();
		
		person.setAge(21);
		person.setName("Joe");
		person.setEmailAddress("joe@yahoo.com");
		person.setGender(Person.Sex.MALE);
		person.setBirthday(LocalDate.parse("1990-01-12",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		person = new Person();
		
		person.setAge(27);
		person.setName("Marcus");
		person.setEmailAddress("marcus24@hotmail.com");
		person.setGender(Person.Sex.MALE);
		person.setBirthday(LocalDate.parse("1989-11-12",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		
		person = new Person();
		
		person.setAge(25);
		person.setName("Mary");
		person.setEmailAddress("mary@yahoo.com");
		person.setGender(Person.Sex.FEMALE);
		person.setBirthday(LocalDate.parse("1991-08-22",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		person = new Person();
		
		person.setAge(26);
		person.setName("Julia");
		person.setEmailAddress("julia@hotmail.com");
		person.setGender(Person.Sex.FEMALE);
		person.setBirthday(LocalDate.parse("1990-02-18",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		person = new Person();
		
		person.setAge(36);
		person.setName("John");
		person.setEmailAddress("john@yahoo.com");
		person.setGender(Person.Sex.MALE);
		person.setBirthday(LocalDate.parse("1980-11-12",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		person = new Person();
		
		person.setAge(23);
		person.setName("Smith");
		person.setEmailAddress("smith@yahoo.com");
		person.setGender(Person.Sex.MALE);
		person.setBirthday(LocalDate.parse("1993-05-12",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		person = new Person();
		
		person.setAge(28);
		person.setName("Rabee");
		person.setEmailAddress("Rabee@hotmail.com");
		person.setGender(Person.Sex.FEMALE);
		person.setBirthday(LocalDate.parse("1988-01-12",DateTimeFormatter.ISO_DATE ));
		people.add(person);
		
		System.out.println("This Stream checks whether the Person is Female and <=28 && => 20 years old");
		people
			.stream()
			.filter(PersonRunner::checkPerson)
			.filter(PersonRunner::checkFemale)
			.forEach(p -> System.out.println(p.getName()));
		System.out.println("");
		
		
		System.out.println("This Stream checks whether the Person is => 30 years old");
		
		int age = 30;
		people
			.stream()
			.filter(p-> p.getAge() > age )
			.forEach(p -> System.out.println(p.getName() + "  " + p.getBirthday()));
		System.out.println("");
		
		System.out.println("This Stream checks whether the Person's email is from hotmail.com");

		people
			.stream()
			.filter(s-> s.getEmailAddress().endsWith("hotmail.com"))
			.forEach(p -> System.out.println(p.getName() + "  " + p.getEmailAddress()));
		
		System.out.println("");
		System.out.println("Get Average Age");
		double age1 =
				people
				.stream()
				.mapToDouble(p -> p.getAge())
				.average()
				.getAsDouble();
		System.out.println(Math.floor(age1));
		System.out.println("");
		System.out.println("Print out all Males");
		List<Person> malesOnly =
				people
				.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.collect(Collectors.toList());
		malesOnly
		.stream()
		.forEach(s->s.printPerson());
		System.out.println("");
		System.out.println("Total Ages");
		int totalAges =
		people
		.stream()
		.mapToInt(s-> s.getAge())
		.sum();
		System.out.println(totalAges);
		
		System.out.println("");
		
		IntSummaryStatistics ageSummary =
				people
				.stream()
				.collect(Collectors.summarizingInt(p -> p.getAge()));

		System.out.println(ageSummary);
		
		System.out.println("");
		
		String phrase = people
			    .stream()
			    .filter(p -> p.getAge() >= 18)
			    .map(p -> p.name)
			    .collect(Collectors.joining(", ", "In Germany ", " are of legal age."));

		System.out.println(phrase);
			
		Map<Integer, String> map = 
				people
				.stream()
				.collect(Collectors.toMap(
				        p -> p.getAge(),
				        p -> p.getName(),
				        (name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
			
		
	}
	
	public static boolean checkPerson(Person p){
		return p.gender == Person.Sex.FEMALE  && p.getAge() >= 20  && p.getAge() <= 28;
	} 
	public static boolean checkFemale(Person p){
		return p.gender == Person.Sex.FEMALE;
	}
	
}
