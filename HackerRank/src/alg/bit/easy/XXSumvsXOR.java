package alg.bit.easy;

import java.util.Scanner;

public class XXSumvsXOR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.println(sumvsXor2(n));
	}

	private static long sumvsXor2(long n) {
		long number = n;
		int zeros = 0;
		while (number > 0) {
			if ((number & 1L) == 0)
				zeros++;
			number = number >> 1;
		}
		return (long) Math.pow(2, zeros);
	}

	private static long sumvsXor(long n) {
		long count = 0;
		for (long i = 0; i <= n; i++) {
			if (n + i == xor(n, i))
				count++;
		}
		return count;
	}

	private static long xor(long n1, long n2) {
		long bigger = n1 > n2 ? n1 : n2;
		long smaller = n1 < n2 ? n1 : n2;
		long result = 0;
		int index = 0;
		while (smaller > 0) {
			long tmp = (smaller & 1) ^ (bigger & 1);
			result = result | tmp << index;
			smaller /= 2;
			bigger /= 2;
			index++;
		}
		while (bigger > 0) {
			long tmp = bigger & 1;
			result = result | tmp << index;
			bigger /= 2;
			index++;
		}
		return result;
	}
}
