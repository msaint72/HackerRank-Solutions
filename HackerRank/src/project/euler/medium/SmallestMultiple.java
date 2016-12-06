package project.euler.medium;

import java.util.Scanner;

public class SmallestMultiple {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(lcm1toN(n));
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int lcm1toN(int n) {
		int number = 2;
		int result = 1;
		while (number <= n) {
			result = lcm(result, number++);
		}
		return result;
	}
}
