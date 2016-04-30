import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServerRunner {
	/**
	 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html	
	 * @param Oracle Tutorial
	 */
	
	
	
	public static void main(String[] args) {
		List<Server> servers = new ArrayList<>();
		Server one = new Server();
		
		one.setIp("192.09.091.12");
		one.setManufacturer("Dell");
		one.setName("web01");
		one.setNumProcessors(9);
		one.setRam(8);
		one.setPurchaseDate(LocalDate.parse("2015-11-01", DateTimeFormatter.ISO_DATE));
		
		servers.add(one);
		
		
		one = new Server();
		one.setIp("192.09.091.121");
		one.setManufacturer("HP");
		one.setName("web02");
		one.setNumProcessors(8);
		one.setRam(7);
		one.setPurchaseDate(LocalDate.parse("2010-12-01", DateTimeFormatter.ISO_DATE));
		
		servers.add(one);
		
		one = new Server();
		one.setIp("192.09.091.125");
		one.setManufacturer("HP");
		one.setName("web24");
		one.setNumProcessors(12);
		one.setRam(17);
		one.setPurchaseDate(LocalDate.parse("2010-12-01", DateTimeFormatter.ISO_DATE));
		
		servers.add(one);
		
		
		one = new Server();
		one.setIp("190.12.91.12");
		one.setManufacturer("Dell-1");
		one.setName("web09");
		one.setNumProcessors(12);
		one.setRam(9);
		one.setPurchaseDate(LocalDate.parse("2012-01-01", DateTimeFormatter.ISO_DATE));

		servers.add(one);
		
		
		one = new Server();
		one.setIp("192.09.10.12");
		one.setManufacturer("Ubuntu");
		one.setName("web12");
		one.setNumProcessors(19);
		one.setRam(18);
		one.setPurchaseDate(LocalDate.parse("2015-01-01", DateTimeFormatter.ISO_DATE));
		
		servers.add(one);
		
		one = new Server();
		one.setIp("190.019.09.125");
		one.setManufacturer("Apache");
		one.setName("web01");
		one.setNumProcessors(9);
		one.setRam(8);
		one.setPurchaseDate(LocalDate.parse("2013-11-11", DateTimeFormatter.ISO_DATE));
		
		servers.add(one);	
		
		String manufacturer = "HP";
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Here are the names of the servers made by " + manufacturer + " currently in inventory:");

		servers
			.stream()
			.filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
			.forEach(s -> System.out.println(s.getName() +" <==> "+ s.getIp() ));
		System.out.println("");
		
		
		System.out.println("Prints out all the servers name by Name ");
		servers
			.stream()
			.forEach(server -> System.out.println(server.getName()));
		System.out.println("");
		
		long age = 3;
		
		System.out.println("Prints out all the servers where age is greater than 3 ");
		servers
			.stream()
			.filter(s1 -> s1.getServerAge() > age)
			.forEach(server -> System.out.println(server.getName()));
		System.out.println("");
		
		
		System.out.println("Average Age for the Servers ");
		double getAverageAge = 
				servers
				.stream()
				.mapToLong(s -> s.getServerAge())
				.average()
				.getAsDouble();
		
		System.out.print(getAverageAge);
		
		System.out.println("");
		List<Server> oldServers =
				servers
				.stream()
				.filter(s -> s.getServerAge() > 2)
				.collect(Collectors.toList());
		System.out.println("");
		
		System.out.println("Send servers to New Store: ");
		oldServers 
				.stream()
				.forEach(s -> System.out.println(s.getName()));
	}
}
