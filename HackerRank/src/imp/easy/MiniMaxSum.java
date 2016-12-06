package imp.easy;

import java.util.Scanner;

public class MiniMaxSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long d = in.nextLong();
		long e = in.nextLong();
		long max = Math.max(e, Math.max(d, Math.max(c, Math.max(a, b))));
		long min = Math.min(e, Math.min(d, Math.min(c, Math.min(a, b))));
		System.out.println((a + b + c + d + e - max) + " " + (a + b + c + d + e - min));
	}
}
