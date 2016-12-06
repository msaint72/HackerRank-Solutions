package project.euler.easy;

import java.util.Scanner;

public class MultiplesOf3And5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(getTotal(n));
		}
	}

	public static long getTotal(int n) {
		int n3;
		if (n % 3 == 0)
			n3 = n - 3;
		else {
			n3 = n / 3;
			n3 = n3 * 3;
		}
		int n5;
		if (n % 5 == 0)
			n5 = n - 5;
		else {
			n5 = n / 5;
			n5 = n5 * 5;
		}
		int n15;
		if (n % 15 == 0)
			n15 = n - 15;
		else {
			n15 = n / 15;
			n15 = n15 * 15;
		}
		// 3 multiples total
		long total = ((long) n3 / 3L) * ((long) n3 + 3L) / 2L;
		total += ((long) n5 / 5L) * ((long) n5 + 5L) / 2L;
		total -= ((long) n15 / 15L) * ((long) n15 + 15L) / 2L;
		return total;
	}
}
