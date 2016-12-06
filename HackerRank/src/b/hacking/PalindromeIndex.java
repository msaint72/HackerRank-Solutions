package b.hacking;

import java.util.Scanner;

public class PalindromeIndex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			String s = in.next();
			printPalindromeIndex(s);
		}

	}

	public static boolean isPalidrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!(s.charAt(start) == s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private static void printPalindromeIndex(String s) {
		if (isPalidrome(s)) {
			System.out.println("-1");
			return;
		}

		int start = 0;
		int end = s.length()-1;
		while (start < end) {
			if ((s.charAt(start) == s.charAt(end))) {
				start++;
				end--;
			} else {
				// first try to remove start
				String newString = s.substring(0, start) + s.substring(start + 1, s.length());
				if (isPalidrome(newString)) {
					System.out.println(start);
					return;
				}
				// then try to remove end
				newString = s.substring(0, end) + s.substring(end + 1, s.length());
				if (isPalidrome(newString)) {
					System.out.println(end);
					return;
				}
				System.out.println("-1");
				return;
			}

		}
		System.out.println("-1");
	}
}
