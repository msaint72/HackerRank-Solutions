package imp.easy;

import java.util.Scanner;

public class FindDigits {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			int tmp = n;
			int count = 0;
			while (tmp > 0) {
				int digit = tmp % 10;
				if (digit != 0 && n % digit == 0) {
					count++;
				}
				tmp = tmp / 10;
			}
			System.out.println(count);
		}
	}
}
