
public class Fibonacci {

	public static void fib(int first, int second) {
		int a = first;
		int b = second;
		
		if (a > 1000 || b > 1000)
			return;
		System.out.print(a + ", " + b + ", ");
		
		// TODO figure out how to print out properly.
		// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
		
		int c = a + b;
		int d = b + c;
		fib(c, d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib(1, 1);
	}

}
