package b.hacking;

import java.util.Scanner;

public class BetweenTwoSets {
	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static long lcm(long a, long b) {
		return (long) a * (long) b / gcd(a, b);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();

		}
		long lcm;
		if (a.length == 1) {
			lcm = a[0];
		} else {
			lcm = lcm(a[0], a[1]);
		}
		if (a.length > 2) {
			for (int i = 2; i < a.length; i++) {
				lcm = lcm(lcm, a[i]);
			}
		}
		int count = 0;
		boolean ok = true;
		int multiplier = 1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < b.length; i++) {
			if (min > b[i])
				min = b[i];
		}
		long value = lcm * multiplier;
		while (value <= min) {
			for (int i = 0; i < b.length; i++) {
				if (b[i] % value != 0) {
					ok = false;
					break;
				}
			}
			if (ok)
				count++;
			multiplier++;
			value = lcm * multiplier;
			ok = true;
		}
		System.out.println(count);
	}
}
