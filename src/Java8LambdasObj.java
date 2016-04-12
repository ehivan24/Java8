interface E{
	int ex(int a, int b);
}
class Running{
	public int run(E e){
		return e.ex(9, 9);
	}
}
public class Java8LambdasObj {
	public static void main(String[] args) {
		Running running = new Running();
		
		E code = (E)(a,b)->{
			System.out.println("Total: " + (a+b));
			return a+b;
		};
		
		running.run(code);
		
	}

}
