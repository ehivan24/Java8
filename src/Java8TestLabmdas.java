/*
 * functional interface
 */
interface ExecutableNew{
	void execute();
}
class RunnerNew{
	public void run(Executable executable) {
		System.out.println("Executing code block...");
		executable.execute();
	}
}
public class Java8TestLabmdas {
	public static void main(String[] args) {
		RunnerNew runner = new RunnerNew();
		
		/**
		 * returning a single line of code
		 */
		runner.run(()-> System.out.println("Single Line Lambda"));
		/**
		 *  Returning a block of code 
		 */
		runner.run(()-> {
			System.out.println("Block Line 1");
			System.out.println("Block Line 2");
			System.out.println("Block Line 3");
			System.out.println("Block Line 4");
		});
	}
}

