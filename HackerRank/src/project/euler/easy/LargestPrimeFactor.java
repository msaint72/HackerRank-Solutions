package project.euler.easy;

import java.util.Scanner;

public class LargestPrimeFactor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			if (isPrime(n))
				System.out.println(n);
			else
				System.out.println(largestPrimeFactor(n));
		}
	}

	public static long largestPrimeFactor(long n) {
		long number = n;
		while (number % 2 == 0) {
			number = number / 2;
		}
		if (number == 1)
			return 2;

		long temp = (long) Math.sqrt(number);
		long divisor = 3;
		while (divisor <= temp) {
			if (number % divisor == 0) {
				number = number / divisor;
				divisor = 3;
				temp = (long) Math.sqrt(number);
			} else
				divisor += 2;
			;
		}
		if (number == 1)
			return divisor;
		return number;

	}

	public static boolean isPrime(long number) {
		if (number == 2)
			return true;
		if (number % 2 == 0)
			return false;
		for (long i = 3; i * i <= number; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;

	}
}
