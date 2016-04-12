interface Executable{
	void execute();
}

class Runner{
	public void run(Executable e) {
		System.out.println("Executing code block...");
		e.execute();
	}
}
public class Java8Test {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable() {
			@Override
			public void execute() {
				System.out.println("Hello There");
			}
		});
	}
}


