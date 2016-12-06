package project.euler.easy;

import java.util.Scanner;

public class EvenFibonacciNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			long prev_prev = 1;
			long prev = 2;
			long total = 2;
			while (prev_prev + prev <= n) {
				long number = prev_prev + prev;
				prev_prev = prev;
				prev = number;
				if (number % 2 == 0)
					total += number;
			}
			System.out.println(total);
		}
	}
}
