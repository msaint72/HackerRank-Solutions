package project.euler.medium;

import java.util.Scanner;

public class LargestPalindromeProduct {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(largestPalindrom(n));
		}
	}

	private static int largestPalindrom(int n) {
		int max = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = 999; j > 99; j--) {
				int number = i * j;
				if (number < n && isPalindrom(number)) {
					max = (int) Math.max(max, number);
				}
			}
		}
		return max;
	}

	private static boolean isPalindrom(int number) {
		String str = new Integer(number).toString();

		int half = str.length() / 2;
		int n = str.length();
		int index = 0;
		while (index < half) {
			if (str.charAt(index) != str.charAt(n - 1 - index))
				return false;
			index++;
		}
		return true;
	}
}
