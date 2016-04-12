/*
 * interface with return statement and parameter 
 */

interface Exe{
	int exc(int a);
}

interface StringExe{
	int executable(String str);
}

class Runs{
	public void run(Exe e) {
		System.out.println("Executing Line of code...");
		int val = e.exc(3);
		System.out.println("Return value :" + val);
	}
	public void run(StringExe e) {
		System.out.println("Executing Line of code...");
		int val = e.executable("Hello");
		System.out.println("Return value :" + val);
	}
	
	
}
public class Java8TestLambdasParameters {
	public static void main(String[] args) {
		Runs runs = new Runs();
		runs.run(new Exe() {
			
			@Override
			public int exc(int a) {
				System.out.println("returns add");
				return 7+a;
			}
		});
		
		/*
		 * specify the return type and 
		 * the parameter inside the ();
		 */
		
		System.out.println("======");
		runs.run((int a)-> 9);
		
		/*
		 * block of line we dont need to specify
		 * the return type for instance 
		 * runs.run((a)-> 9);
		 * if there is only one method
		 */
		
		runs.run((int a)-> {
			System.out.println("Addition: ");
			return 1+a;
		});
		
		runs.run((String str)-> {
			System.out.println("String: ");
			return 1;
		});
		
	}
}
