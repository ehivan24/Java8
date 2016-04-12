/*
 * Lambdas and returning type int 
 */

interface Exec {
	int execute();
} 
class RunExecute{
	public void run(Exec e){
		System.out.println("Executing Line of code...");
		int value = e.execute();
		System.out.println("The value is: " + value);
	}
}

public class Java8TestLambdasReturn {

	public static void main(String[] args) {
		
		RunExecute runExecute = new RunExecute();
		runExecute.run(new Exec() {
			
			@Override
			public int execute() {
				System.out.println("The value is: Anonimous " );
				return 7;
			}
		});
		
		/*
		 * Block of Code
		 */
		runExecute.run(()-> {
			System.out.println("Returned ");
			return 8;
		});
		/*
		 * Single Expression valid in Lambdas
		 */
		runExecute.run(()-> 10);
		
	}

}
