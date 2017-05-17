import java.util.Scanner;

public class GCD {

	public static int gcd(int a, int b) {
		// This is the Euclidean Algorithm.
		// If "a" == 0, GCD is "|a|"
		// If "b" == 0, GCD is "|b|"
		
		
		if (a == 0 || b == 0)
			return Math.abs(a + b); // if either a or b is 0, the GCD of the two
									// is the absolute value of the non-zero number
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a, b;
		
		System.out.print("Enter the first number: ");
		a = s.nextInt();
		System.out.print("Enter the second number: ");
		b = s.nextInt();
		
		int answer = gcd(a, b);
		
		System.out.println("The GCN of " + a + " and " + b + " is " + answer);

	}

}
