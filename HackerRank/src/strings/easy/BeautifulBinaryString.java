package strings.easy;

import java.util.Scanner;

public class BeautifulBinaryString {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String B = in.next();
		if (n < 3) {
			System.out.println("0");
			return;
		}
		int count = 0;
		for (int i = 0; i < n - 2; i++) {
			char c1 = B.charAt(i);
			char c2 = B.charAt(i + 1);
			char c3 = B.charAt(i + 2);
			if (c1 == '0' && c2 == '1' && c3 == '0') {
				B = B.substring(0, i + 2) + "1" + B.substring(i + 3);
				count++;
			}

		}
		System.out.println(count);
	}
}
