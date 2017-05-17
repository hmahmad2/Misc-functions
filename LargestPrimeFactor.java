import java.util.Scanner;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class LargestPrimeFactor
{
	
	public static long lpf(long num)
	{
		if (num <= 1)
		{
			System.out.print(num + " is not a valid input. Error code: ");
			return -1;
		}
		
		long n = num;
		long largestPrime = 1;
		
		if (n % 2 == 0)
		{
			largestPrime = 2;
			do {
				n /= 2;
			} while (n % 2 == 0);
		}
		if (n % 3 == 0) {
			largestPrime = 3;
			do {
				n /= 3;
			} while (n % 3 == 0);
		}
		
		// Going to use the Euler's 6n + 1 theorem
		long multSix = 6;
		while ((multSix - 1) <= n) {
			
			if (n % (multSix - 1) == 0) {
				largestPrime = multSix - 1;
				do {
					n /= (multSix - 1);
				} while (n % (multSix - 1) == 0);
			}
			
			if (n % (multSix + 1) == 0) {
				largestPrime = (multSix + 1);
				do {
					n /= (multSix + 1);
				} while (n % (multSix + 1) == 0);
			}
			
			multSix += 6;
		}
		
		return largestPrime;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Input a number greater than 1: ");
		long k;
		long s;
		boolean failsafe = true;
		if (scan.hasNextLong()) {
			s = scan.nextLong();
		}
		else {
			System.out.println("Not a vaild input");
			failsafe = false;
			scan.close();
			return;
		}
		if (s < 1) {
			System.out.println("Not a valid input");
			failsafe = false;
			scan.close();
			return;
		}
		
		scan.close();
		k = lpf(s);
		if (failsafe == true)
			System.out.println("The largest prime factor of " + s + " is " + k);
	}

}
